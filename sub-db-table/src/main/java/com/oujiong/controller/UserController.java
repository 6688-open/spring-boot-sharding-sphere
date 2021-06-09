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
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


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
        userList.add(new User(1L,"小小", "女", 2,  getRandom(2) +dbId_01 + getRandom(13)));//分库时 会对 （2,4）截取 dbId
        userList.add(new User(2L,"爸爸", "男", 30, getRandom(2) +dbId_01 + getRandom(13)));
        userList.add(new User(3L,"妈妈", "女", 28, getRandom(2) +dbId_01 + getRandom(13)));
        userList.add(new User(4L,"爷爷", "男", 64, getRandom(2) +dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, getRandom(2) +dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "10" +dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "20" +dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "30" +dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "40" +dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "50" +dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "60"+dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "70"+dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "80"+dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "90"+dbId_02 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "11" +dbId_01 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "20" +dbId_01 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "30" +dbId_01 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "40" +dbId_01 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "50" +dbId_01 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "60"+dbId_01 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "70"+dbId_01 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "80"+dbId_01 + getRandom(13)));
        userList.add(new User(5L,"奶奶", "女", 62, "90"+dbId_01 + getRandom(13)));
    }
    /**
     * http://localhost:8088/save-user
     * @Description: 批量保存用户
     */
    @PostMapping("save-user")
    public Object saveUser() {
        Long maxId = userService.selectMaxId();
        maxId = maxId == null ? 1 : maxId;
        AtomicInteger i = new AtomicInteger(1);
        Long finalMaxId = maxId;
        userList.forEach(user -> {
            user.setId(finalMaxId + i.get());
            user.setName(user.getName()+ user.getId());
            i.getAndIncrement();
        });
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



     /**
      * 获取指定长度的数字随机数
      * @param size 随机数个数
      * @return 指定长度的数字随机数的字符串
      */
     public static String getRandom(int size) {
         Random random = new Random();
         StringBuilder sb = new StringBuilder(size);
         for (int i = 0; i < size; i++) {
             sb.append(random.nextInt(9));
         }
         return sb.toString();
   }


}
