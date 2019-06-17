package com.danilopereira.consumer;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

public interface Consumer {

    void create(ConnectionFactory connectionFactory, String destinationName) throws JMSException;
    void close() throws JMSException;
    String getGreeting() throws JMSException;
}
