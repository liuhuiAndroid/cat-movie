package com.stylefeng.guns.api.alipay;

import com.stylefeng.guns.api.alipay.vo.AliPayInfoVO;
import com.stylefeng.guns.api.alipay.vo.AliPayResultVO;

/**
 * Created by lucasma
 */
public interface AliPayServiceAPI {

    // 获取二维码
    AliPayInfoVO getQRCode(String orderId);

    // 获取订单支付状态
    AliPayResultVO getOrderStatus(String orderId);

}
