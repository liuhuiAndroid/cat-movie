package com.stylefeng.guns.api.alipay.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lucasma
 */
@Data
public class AliPayInfoVO implements Serializable {

    private String orderId;
    private String QRCodeAddress;
}
