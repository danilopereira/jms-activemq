package com.danilopereira.app;

import com.danilopereira.producer.Producer;
import com.danilopereira.producer.ProducerImpl;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

public class ProducerApp {

    public static void main(String [] args){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("artemis", "simetraehcapa", ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        try {
            Producer producer = new ProducerImpl(connectionFactory, "activeMQ.q");

            producer.sendName("Danilo", "Pereira");
            producer.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
