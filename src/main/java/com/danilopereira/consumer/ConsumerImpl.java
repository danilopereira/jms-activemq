package com.danilopereira.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class ConsumerImpl implements Consumer {

    private final static String NO_GREETING = "no greeting";
    private int timeout;
    private Connection connection;
    private MessageConsumer messageConsumer;


    @Override
    public void create(ConnectionFactory connectionFactory, String destinationName) throws JMSException {
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
        String greeting = NO_GREETING;
        Message message = messageConsumer.receive(timeout);

        if(message != null){
            TextMessage textMessage = (TextMessage) message;
            greeting = "Hello " + textMessage.getText() + "!";
        }

        return greeting;
    }
}
