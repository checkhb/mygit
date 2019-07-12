package com.example.springaop.proxy;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/24 16:51
 * @Version 1.0
 */
public class ProxyObject implements Subject {

    @Autowired
    TargetObject targetObject;

    public ProxyObject(TargetObject targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public void requset() {
        System.out.println("Before");
        try {
            targetObject.requset();
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("after");
        }
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
