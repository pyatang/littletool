package org.lytang.littletool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.Map;

@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")//这就是配置的bean时候的队列名字
    public void receiveQueue(String text) {
        System.out.println("得到的消息：" + text);
    }

    @Autowired
    private JmsOperations jmsOperations;

    /**
     * jmsOperations 的 receiveAndConvert() 方法
     */
    @Test
    public void receiveAndConvert(){
        Map<String, Object> map = (Map) jmsOperations.receiveAndConvert("new.queue");
    }



}