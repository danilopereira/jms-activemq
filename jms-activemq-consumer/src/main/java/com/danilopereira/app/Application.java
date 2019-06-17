package com.danilopereira.app;

import com.danilopereira.consumer.Consumer;
import com.danilopereira.consumer.ConsumerImpl;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

public class Application {

    public static void main(String [] args){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("artemis", "simetraehcapa", ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Consumer consumer = null;
        try {
            consumer = new ConsumerImpl(connectionFactory, 60, "activeMQ.q");
            while(true){
                String message = consumer.getGreeting();
                if(null == message){
                    Thread.sleep(2000);
                    continue;
                }
                System.out.println(message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try{
                consumer.close();
            } catch (JMSException ex){
                ex.printStackTrace();
            }
        }
    }
}
