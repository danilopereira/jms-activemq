package com.danilopereira.producer;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

public interface Producer {

     void create(ConnectionFactory connectionFactory, String destinationName) throws JMSException;
     void close() throws JMSException;
     void sendName(String firstName, String lastName) throws JMSException;

}
