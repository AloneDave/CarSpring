package net.hnkj.carspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//扫描mapper层的接口
@MapperScan("net.hnkj.carspring.mapper")
//开启事物管理器
@EnableTransactionManagement
public class CarSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSpringApplication.class, args);
    }

}
