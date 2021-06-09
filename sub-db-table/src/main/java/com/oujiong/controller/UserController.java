package com.oujiong.controller;


import com.google.common.collect.Lists;
import com.oujiong.entity.User;
import com.oujiong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * @Description: 接口测试
 *
 * @author wj
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 模拟插入数据
     */
    List<User> userList = Lists.newArrayList();

    public static final String dbId_01 = "01";
    public static final String dbId_02 = "02";
    /**
     * 初始化插入数据
     */
    @PostConstruct
    private void getData() {
        userList.add(new User(1L,"小小", "女", 2,  "12"+dbId_01 +"4444567890246"));//分库时 会对 （2,4）截取 dbId
        userList.add(new User(2L,"爸爸", "男", 30, "12"+dbId_01 +"5554567890246" ));
        userList.add(new User(3L,"妈妈", "女", 28, "12"+dbId_02 +"6664567890246" ));
        userList.add(new User(4L,"爷爷", "男", 64, "12"+dbId_02 +"7774567890246"));
        userList.add(new User(5L,"奶奶", "女", 62, "12"+dbId_02 +"8884567890246"));
    }
    /**
     * http://localhost:8088/save-user
     * @Description: 批量保存用户
     */
    @PostMapping("save-user")
    public Object saveUser() {
        return userService.insertForeach(userList);
    }
    /**
     * http://localhost:8088/list-user
     * @Description: 获取用户列表
     */
    @GetMapping("list-user")
    public Object listUser() {
        return userService.list();
    }


}
