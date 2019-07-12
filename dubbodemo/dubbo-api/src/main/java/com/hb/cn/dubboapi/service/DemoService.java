package com.hb.cn.dubboapi.service;

import java.util.List;

public interface DemoService {
    List<String> getPermissions(Long id);
}
