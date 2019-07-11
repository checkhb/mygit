package com.example.springaop.aspect;

import com.example.springaop.test.AuthService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/21 17:44
 * @Version 1.0
 */
@Aspect
@Component
public class SecurityAspect {

    @Autowired
    AuthService authService;

    @Pointcut("@annotation(com.example.springaop.annotation.AdminOnly)")
    private void adminOnly(){

    }

//    @Before("adminOnly()")
//    public void check(){
//        authService.checkAccess();
//    }

    @After("adminOnly()")
    public void check2(){
        authService.checkAccess();
    }
}
