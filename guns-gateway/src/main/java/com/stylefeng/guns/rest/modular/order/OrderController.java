package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.api.order.vo.OrderVO;
import com.stylefeng.guns.core.util.TokenBucket;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.EAN;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/order/")
public class OrderController {

    private static TokenBucket tokenBucket = new TokenBucket();

    @Reference(interfaceClass = OrderServiceAPI.class, check = false, timeout = 8000, group = "order2018")
    private OrderServiceAPI orderServiceAPI;

    @Reference(interfaceClass = OrderServiceAPI.class, check = false, timeout = 8000, group = "order2017")
    private OrderServiceAPI orderServiceAPI2017;

    /**
     * 服务降级方法，注意参数需要一致
     *
     * @param fieldId
     * @param soldSeats
     * @param seatsName
     * @return
     */
    public ResponseVO error(Integer fieldId, String soldSeats, String seatsName) {
        return ResponseVO.serviceFail("抱歉，下单的人太多了，请稍后重试");
    }

    /**
     * 用户下单购票
     * Hystrix有信号量隔离，线程池隔离，线程切换等保护机制，导致ThreadLocal无法使用，需要使用InheritableThreadLocal
     *
     * @param fieldId   场次编号
     * @param soldSeats 购买座位编号
     * @param seatsName 购买座位名称
     * @return
     */
    @HystrixCommand(fallbackMethod = "error", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000"), // 超时时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求数量
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")}, // error百分比
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1500")
            })
    @RequestMapping(value = "buyTickets", method = RequestMethod.POST)
    public ResponseVO buyTickets(Integer fieldId, String soldSeats, String seatsName) {
        // 认为制造异常，测试服务降级
        // int i = 5 / 0;
        try {
            // 限流：如果能拿到 token，所有业务继续，拿不到则返回
            // TODO 考虑增加队列缓存一下未获得令牌的请求
            if (tokenBucket.getToken()) {
                // TODO 分布式事务
                // TODO 同步改异步，否则性能会非常差
                // 验证售出的票是否为真
                boolean isTrue = orderServiceAPI.isTrueSeats(fieldId + "", soldSeats);
                // 已经销售的座位里，有没有这些座位
                boolean isNotSold = orderServiceAPI.isNotSoldSeats(fieldId + "", soldSeats);
                // 验证，上述两个内容有一个不为真，则不创建订单信息
                if (isTrue && isNotSold) {
                    // 创建订单信息,注意获取登录人
                    String userId = CurrentUser.getCurrentUserId();
                    if (userId == null || userId.trim().length() == 0) {
                        return ResponseVO.serviceFail("用户未登录");
                    }
                    OrderVO orderVO = orderServiceAPI.saveOrderInfo(fieldId, soldSeats, seatsName, Integer.parseInt(userId));
                    if (orderVO == null) {
                        log.error("购票未成功");
                        return ResponseVO.serviceFail("购票业务异常");
                    } else {
                        return ResponseVO.success(orderVO);
                    }
                } else {
                    return ResponseVO.serviceFail("订单中的座位编号有问题");
                }
            } else {
                return ResponseVO.serviceFail("购票人数过多，请稍后再试");
            }
        } catch (Exception e) {
            log.error("购票业务异常: ", e);
            return ResponseVO.serviceFail("购票业务异常");
        }
    }

    /**
     * 获取订单信息
     *
     * @param nowPage  当前页
     * @param pageSize 每页多少条
     * @return
     */
    @RequestMapping(value = "getOrderInfo", method = RequestMethod.POST)
    public ResponseVO getOrderInfo(
            @RequestParam(name = "nowPage", required = false, defaultValue = "1") Integer nowPage,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        // 获取当前登录人的信息
        String userId = CurrentUser.getCurrentUserId();
        // 使用当前登录人获取已经购买的订单
        Page<OrderVO> page = new Page<>(nowPage, pageSize);
        if (userId != null && userId.trim().length() > 0) {
            Page<OrderVO> result = orderServiceAPI.getOrderByUserId(Integer.parseInt(userId), page);
            Page<OrderVO> result2017 = orderServiceAPI2017.getOrderByUserId(Integer.parseInt(userId), page);
            // 合并结果
            int totalPages = (int) (result.getPages() + result2017.getPages());
            List<OrderVO> orderVOs = new ArrayList<>();
            orderVOs.addAll(result.getRecords());
            orderVOs.addAll(result2017.getRecords());
            return ResponseVO.success(nowPage, totalPages, "", orderVOs);
        } else {
            return ResponseVO.serviceFail("用户未登录");
        }
    }

}
