package com.example.springaop.dynamic;

import com.example.springaop.proxy.TargetObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/24 17:32
 * @Version 1.0
 */
public class JdkProxySubject implements InvocationHandler {
    @Autowired
    TargetObject targetObject;

    public JdkProxySubject(TargetObject targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = null;
        try {
            invoke = method.invoke(targetObject, args);
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("after");
        }
        return invoke;
    }
}
