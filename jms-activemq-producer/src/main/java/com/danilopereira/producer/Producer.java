package com.danilopereira.producer;

import javax.jms.JMSException;

public interface Producer {

     void close() throws JMSException;
     void sendName(String firstName, String lastName) throws JMSException;

}
