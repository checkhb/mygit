package com.example.springaop.proxy;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/24 16:50
 * @Version 1.0
 */
public class TargetObject implements Subject {
    @Override
    public void requset() {
        System.out.println("is targetObject work");
    }

    @Override
    public void hello() {

    }
}
