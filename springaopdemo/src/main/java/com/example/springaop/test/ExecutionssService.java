package com.example.springaop.test;

import com.example.springaop.test.CurrentUserHolder;
import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/24 14:58
 * @Version 1.0
 */
@Service
public class ExecutionssService {

    public Object executionTest() throws Exception {
        String user = CurrentUserHolder.get();
        int a = 10 / 0;
        System.out.println("ExecutionService 被拦截");
        return ExecutionssService.class;
    }
}
