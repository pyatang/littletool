package org.lytang.littletool;



import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;


@EnableJms
@SpringBootApplication
public class LittleTool {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");

    }

    public static void main(String[] args) {
        SpringApplication.run(LittleTool.class, args); }



}
