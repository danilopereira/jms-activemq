package com.danilopereira.consumer;

import javax.jms.JMSException;

public interface Consumer {

    void close() throws JMSException;
    String getGreeting() throws JMSException;
}
