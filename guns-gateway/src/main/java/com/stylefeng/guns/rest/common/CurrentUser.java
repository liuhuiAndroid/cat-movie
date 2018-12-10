package com.stylefeng.guns.rest.common;

/**
 * 增加Threadlocal的用户信息保存
 */
public class CurrentUser {

    // 线程绑定的存储空间
    // private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static final InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
    // 因为 Hystrix 会线程切换，InheritableThreadLocal 可以在切换时保存线程信息

    // 将用户id放入存储空间
    public static void saveUserId(String userId) {
        threadLocal.set(userId);
    }

    // 将用户id取出
    public static String getCurrentUserId() {
        return threadLocal.get();
    }

}
