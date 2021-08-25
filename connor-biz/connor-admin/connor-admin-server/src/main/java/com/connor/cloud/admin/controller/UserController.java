package com.connor.cloud.admin.controller;

import com.connor.cloud.admin.dao.dto.AdminUserDTO;
import com.connor.cloud.admin.dao.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private AdminUserMapper adminUserMapper;


    @RequestMapping("/insert")
    public void insertUser() {


        AdminUserDTO build = AdminUserDTO.builder().name("曾罡").username("zenggang918").password("zenggang918").mobile("15815585147").build();
        adminUserMapper.insert(build);

    }

}
