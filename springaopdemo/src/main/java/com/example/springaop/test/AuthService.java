package com.example.springaop.test;

import com.example.springaop.test.CurrentUserHolder;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/21 18:04
 * @Version 1.0
 */
@Component
public class AuthService {
    public void checkAccess(){
        String user = CurrentUserHolder.get();
        if (!"admin".equals(user)){
            throw new RuntimeException("operation not allow");
        }
    }
}
