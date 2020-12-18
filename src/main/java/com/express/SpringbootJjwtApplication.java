package com.express;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.express.mapper")
public class SpringbootJjwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJjwtApplication.class, args);
    }
}
