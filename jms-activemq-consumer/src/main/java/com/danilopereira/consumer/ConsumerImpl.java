package com.danilopereira.consumer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

@Slf4j
public class ConsumerImpl implements Consumer {

    private int timeout;
    private Connection connection;
    private MessageConsumer messageConsumer;
    private ConnectionFactory connectionFactory;

    public ConsumerImpl(ConnectionFactory connectionFactory, int timeout, String destinationName) throws JMSException {
        this.connectionFactory = connectionFactory;
        this.connection = connectionFactory.createConnection();
        this.timeout = timeout;
        connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(destinationName);
        messageConsumer = session.createConsumer(destination);
        connection.start();
    }


    @Override
    public void close() throws JMSException {
        connection.close();
    }

    @Override
    public String getGreeting() throws JMSException {
        String greeting = null;
        Message message = messageConsumer.receive(timeout);

        if(message != null){
            TextMessage textMessage = (TextMessage) message;
            greeting = "Hello " + textMessage.getText() + "!";
        }
        return greeting;
    }
}
