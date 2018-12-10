package com.stylefeng.sso.client.auth;

import com.stylefeng.sso.plugin.api.AuthApi;
import com.stylefeng.sso.plugin.model.LoginUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户鉴权服务的空实现
 *
 * @author fengshuonan
 * @Date 2018/8/31 下午12:57
 */
@Service
public class AuthApiFactory implements AuthApi {

    @Override
    public LoginUser getLoginUser(Integer userId) {
        return new LoginUser();
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        return new ArrayList<>();
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return "";
    }

}
