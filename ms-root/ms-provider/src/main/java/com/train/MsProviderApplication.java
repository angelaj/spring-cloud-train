package com.train;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.train.provider.mapper")//将项目中对应的mapper类的路径加进来就可以了
@EnableTransactionManagement
public class MsProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProviderApplication.class, args);
	}

}

