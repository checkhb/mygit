package com.example.springaop.proxy;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/24 16:51
 * @Version 1.0
 */
public class TestProxy {
    public static void main(String[] args) {
        ProxyObject proxyObject = new ProxyObject(new TargetObject());
        proxyObject.requset();
    }
}
