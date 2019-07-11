package com.example.springaop.springAop;

public class UserServiceImp implements UserService {
    @Override
    public void printUser(String user) {
        System.out.println("printUser user:" + user);// 显示user
    }
}
