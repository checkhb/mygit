package com.example.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import sun.java2d.loops.ProcessPath;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/24 14:55
 * @Version 1.0
 */
@Aspect
@Component
public class ExecutionAspectConfig {

    @Pointcut("execution(public * com.example.springaop.test..*Service.*(..))")
    public void mathCondition() {

    }

    @Around("mathCondition()")
    public void after(ProceedingJoinPoint joinPoint) {
        System.out.println("##before");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed(joinPoint.getArgs());
            System.out.println("#after retruning");
        } catch (Throwable throwable) {
            System.out.println("#after exception");
            throwable.printStackTrace();
        } finally {
            System.out.println("##finally");
        }

    }
}
