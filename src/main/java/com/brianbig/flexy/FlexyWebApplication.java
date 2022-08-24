package com.brianbig.flexy;

import com.brianbig.flexy.workflow.OrderWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlexyWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlexyWebApplication.class);
        OrderWorker.StartOrderWorker();
    }
}
