package com.stylefeng.guns.core.util;

/**
 * 令牌桶
 * 为什么使用令牌桶：对业务有一定的容忍度
 * TODO 实现一个复杂的令牌桶
 */
public class TokenBucket {

    // 桶的容量
    private int bucketNums = 100;
    // 流入速度
    private int rate = 1;
    // 当前令牌数量
    private int nowTokens;
    // 时间
    private long timestamp = getNowTime();

    private long getNowTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取令牌
     * TODO 上锁
     *
     * @return
     */
    public boolean getToken() {
        // 记录来拿令牌的时间
        long nowTime = getNowTime();
        // 添加令牌【判断该有多少个令牌】
        nowTokens = nowTokens + (int) ((nowTime - timestamp) * rate);
        // 添加以后的令牌数量与桶的容量那个小
        nowTokens = min(nowTokens);
        System.out.println("当前令牌数量" + nowTokens);
        // 修改拿令牌的时间
        timestamp = nowTime;
        // 判断令牌是否足够
        if (nowTokens < 1) {
            return false;
        } else {
            nowTokens -= 1;
            return true;
        }
    }

    private int min(int tokens) {
        if (bucketNums > tokens) {
            return tokens;
        } else {
            return bucketNums;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket();
        for (int i = 0; i < 100; i++) {
            if (i == 10) {
                Thread.sleep(500);
            }
            boolean token = tokenBucket.getToken();
            System.out.println("第" + i + "次：" + token);
        }
    }

}
