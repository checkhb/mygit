package com.example.springaop;

import com.example.springaop.test.CurrentUserHolder;
import com.example.springaop.test.ExecutionssService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringaopApplicationTests {

    @Autowired
    ProductService productService;



    @Autowired
    ExecutionssService executionService;

    @Test
    public void annoInsertTests(){
        CurrentUserHolder.set("tom");
        productService.delete(1L);
    }
    @Test
    public void adminInsert(){
        CurrentUserHolder.set("admin");
        productService.delete(1L);
    }
    @Test
    public void execution() throws Exception {
        executionService.executionTest();

    }
}
