package org.lytang.littletool;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;
import javax.xml.soap.Text;

public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;

        Connection connection = null;

        Session session;

        Destination destination;

        MessageProducer messageProducer;

        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

        try {
            connection = connectionFactory.createConnection();

            connection.start();

            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            destination = session.createQueue("HelloActivemq");

            messageProducer = session.createProducer(destination);

            sendMessage(session, messageProducer);

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    public static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException {
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            TextMessage message = session.createTextMessage("发送一条Activemq 消息" + i);
            System.out.println("发送消息：Activemq 发送消息" + i);
            messageProducer.send(message);
        }
    }



}
