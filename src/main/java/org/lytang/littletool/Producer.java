package org.lytang.littletool;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Component
public class Producer implements CommandLineRunner {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;


    @Autowired
    private JmsOperations jmsOperations;

    @Test
    public void convertAndSend() {
        Map<String, String> map = new HashMap<>();
        map.put("111", "a");
        map.put("222", "b");
        map.put("333", "c");
        this.jmsOperations.convertAndSend("new.queue",map);
    }

    @Override
    public void run(String ... args) throws Exception {
        send("ceshi");
    }

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }


}