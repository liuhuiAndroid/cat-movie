package com.stylefeng.sso.client.controller;

import com.stylefeng.sso.plugin.constants.SsoConstants;
import com.stylefeng.sso.plugin.properties.SsoProperties;
import com.stylefeng.sso.plugin.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.stylefeng.sso.plugin.constants.SsoConstants.LOGOUT_URL;

/**
 * sso客户端的控制器
 *
 * @author fengshuonan
 * @Date 2018/8/31 下午12:30
 */
@Controller
public class ClientController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SsoProperties ssoProperties;

    /**
     * 系统的首页，登录后才可以访问
     *
     * @author fengshuonan
     * @Date 2018/8/31 下午12:57
     */
    @RequestMapping("/")
    public String home() {
        return "index.html";
    }

    /**
     * 退出接口
     *
     * @author fengshuonan
     * @Date 2018/8/31 下午12:57
     */
    @RequestMapping(LOGOUT_URL)
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        //跳转到sso服务器提交申请,注销会话
        String redirectUrl = ssoProperties.getServerUrl() + "/logout"
                + "?" + SsoConstants.REDIRECT_PARAM_NAME + "=" + HttpUtil.encodeUrl(HttpUtil.getRequestContextPath(request))
                + "&" + SsoConstants.TOKEN_PARAM_NAME + "=" + session.getAttribute(SsoConstants.SESSION_LOGIN_FLAG);
        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            log.error("退出跳转到服务器地址出错!", e);
        }
        return null;
    }
}