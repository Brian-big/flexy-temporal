package com.brianbig.flexy;

import com.brianbig.flexy.workflow.OrderWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FlexyWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlexyWebApplication.class);
        OrderWorker.StartOrderWorker();
    }
}
