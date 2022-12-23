package com.stevenprogramming.javaee.wsdl.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.Endpoint;

public class PersonServicePublisher {

    private static final Logger logger = LoggerFactory.getLogger(PersonServicePublisher.class);
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.create(new PersonServiceImpl());
        endpoint.publish("http://localhost:8888/ws/person");

        logger.info("Person web service ready to consume requests! - !");
    }


}
