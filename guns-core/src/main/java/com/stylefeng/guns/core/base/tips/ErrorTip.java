package com.stylefeng.guns.core.base.tips;

import lombok.extern.slf4j.Slf4j;

/**
 * 返回给前台的错误提示
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:05:22
 */
@Slf4j
public class ErrorTip extends Tip {

    public ErrorTip(int status, String msg) {
        super();
        log.error("系统出现异常，异常code={}，异常信息={}", status, msg);
        this.status = status;
        this.msg = msg;
    }

}
