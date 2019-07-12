package com.example.springaop.test;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/21 17:54
 * @Version 1.0
 */
public class CurrentUserHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static String get() {
        return holder.get() == null ? "unknown" : holder.get();
    }

    public static void set(String user) {
        holder.set(user);
    }
}
