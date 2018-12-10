package com.stylefeng.sso.plugin.interceptor;

import com.stylefeng.sso.plugin.api.AuthApi;
import com.stylefeng.sso.plugin.cache.ClientCache;
import com.stylefeng.sso.plugin.constants.SsoConstants;
import com.stylefeng.sso.plugin.model.LoginUser;
import com.stylefeng.sso.plugin.properties.SsoProperties;
import com.stylefeng.sso.plugin.remote.RemoteService;
import com.stylefeng.sso.plugin.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * sso客户端登录拦截器
 *
 * @author fengshuonan
 * @date 2018-02-03 20:35
 */
public class SsoClientInterceptor implements HandlerInterceptor {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private SsoProperties ssoProperties;

    private ClientCache clientCache;

    private RemoteService remoteService;

    private AuthApi authApi;

    public SsoClientInterceptor(SsoProperties ssoProperties, RemoteService remoteService,
                                ClientCache clientCache, AuthApi authApi) {
        this.ssoProperties = ssoProperties;
        this.clientCache = clientCache;
        this.remoteService = remoteService;
        this.authApi = authApi;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        HttpSession session = request.getSession();

        //获取当前用户登录标记
        Object sessionAttribute = session.getAttribute(SsoConstants.SESSION_LOGIN_FLAG);

        //如果没登录
        if (sessionAttribute == null) {

            //检查参数是否携带如果携带token,验证成功后就加入登录标记
            String tokenParam = request.getParameter(SsoConstants.TOKEN_PARAM_NAME);

            //如果带有token参数,调用远程sso sever方法验证token是否正确
            if (tokenParam != null) {
                Integer userId = remoteService.validateToken(tokenParam, HttpUtil.getRequestContextPath(request));

                //userId不为空，token验证成功
                if (userId != null) {
                    session.setAttribute(SsoConstants.SESSION_LOGIN_FLAG, tokenParam);

                    LoginUser loginUser = authApi.getLoginUser(userId);
                    session.setAttribute(SsoConstants.LOGIN_USER_SESSION, loginUser);
                    return true;

                } else {
                    //token验证失败
                    redirectSsoServer(request, response);
                    return false;
                }

            } else {
                //没有携带token参数
                redirectSsoServer(request, response);
                return false;
            }
        } else {

            //当前用户已登录，如果存在被删除的标记则剔除session
            boolean flag = clientCache.containsInvalidKey(sessionAttribute.toString());
            if (flag) {
                session.removeAttribute(SsoConstants.SESSION_LOGIN_FLAG);
                session.invalidate();
                redirectSsoServer(request, response);
                return false;
            } else {

                //当前用户已经登录,也需要验证token是否有效
                Integer userId = remoteService.validateToken(sessionAttribute.toString(), HttpUtil.getRequestContextPath(request));

                //userId不为空，token验证成功
                if (userId != null) {
                    LoginUser loginUser = authApi.getLoginUser(userId);
                    session.setAttribute(SsoConstants.LOGIN_USER_SESSION, loginUser);
                    return true;

                } else {
                    //token验证失败
                    redirectSsoServer(request, response);
                    return false;
                }
            }
        }
    }

    /**
     * 跳转到sso服务器去认证
     */
    private void redirectSsoServer(HttpServletRequest request, HttpServletResponse response) {
        String redirectUrl = ssoProperties.getServerUrl() + "?" + SsoConstants.REDIRECT_PARAM_NAME + "=" + HttpUtil.encodeUrl(HttpUtil.getRequestFullPathNoParam(request));
        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            log.error("跳转到服务器出错!", e);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
