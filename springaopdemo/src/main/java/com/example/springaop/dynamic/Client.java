package com.example.springaop.dynamic;

import com.example.springaop.proxy.Subject;
import com.example.springaop.proxy.TargetObject;

import java.lang.reflect.Proxy;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/24 17:38
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxySubject(new TargetObject()));
        //subject.requset();
        subject.hello();
    }
}
