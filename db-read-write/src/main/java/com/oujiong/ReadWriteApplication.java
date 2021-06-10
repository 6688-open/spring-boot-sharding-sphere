package com.oujiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 启动类
 *
 * @author wj  读写分离 只是实现分离 主表数据同步到从表  需要主从复制
 * @date 2019/10/08 下午6:33
 */
@SpringBootApplication
public class ReadWriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadWriteApplication.class, args);
		System.out.println("ReadWriteApplication start successfully......");
	}

}
