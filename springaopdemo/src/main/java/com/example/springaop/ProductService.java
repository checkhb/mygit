package com.example.springaop;

import com.example.springaop.annotation.AdminOnly;
import com.example.springaop.test.AuthService;
import com.example.springaop.test.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/21 18:01
 * @Version 1.0
 */
@Service
public class ProductService {

    @Autowired
    AuthService authService;

    @AdminOnly
    public void insert(Product product) {
        authService.checkAccess();
        System.out.println("insert product");
    }

    @AdminOnly
    public void delete(Long id) {
        authService.checkAccess();
        System.out.println("delete product");
    }


    public void update(Long id) {
        authService.checkAccess();
        System.out.println("delete product");
    }
}
