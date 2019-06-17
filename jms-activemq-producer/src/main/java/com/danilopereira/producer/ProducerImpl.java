package com.danilopereira.producer;

import lombok.extern.slf4j.Slf4j;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

@Slf4j
public class ProducerImpl implements Producer {
    private Connection connection;
    private Session session;
    private MessageProducer messageProducer;
    private ConnectionFactory connectionFactory;

    public ProducerImpl(ConnectionFactory connectionFactory, String destinationName) throws JMSException {
        this.connectionFactory = connectionFactory;
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(destinationName);
        messageProducer = session.createProducer(destination);
    }

    @Override
    public void close() throws JMSException {
        connection.close();
    }

    @Override
    public void sendName(String firstName, String lastName) throws JMSException {
        String text = firstName + " " + lastName;
        TextMessage textMessage = session.createTextMessage(text);
        messageProducer.send(textMessage);
        log.info("message sent to queue: {}", text);


    }


}
