package com.example.springaop.test;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hubin
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String name;
    private Short sex;
    private String email;
    private String addr;

}
