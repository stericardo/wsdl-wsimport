package com.stevenprogramming.javaee.wsdl.client;

import com.stevenprogramming.javaee.wsdl.client.httpclient.Person;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

public class CallWsdlHttpClientService {

    private static final Logger logger = LoggerFactory.getLogger(CallWsdlHttpClientService.class);

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // https://secure.dev.esoa.qcorpaa.aa.com/CSPaymentService/V21
            HttpGet request = new HttpGet("http://localhost:8888/ws/person?wsdl");

            CloseableHttpResponse response = httpClient.execute(request);

            try {

                // Get HttpResponse Status
                logger.info(response.getProtocolVersion().toString());              // HTTP/1.1
                logger.info(String.valueOf(response.getStatusLine().getStatusCode()));   // 200
                logger.info(response.getStatusLine().getReasonPhrase().toString()); // OK
                logger.info(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                String resultSoap = EntityUtils.toString(entity);
                if (entity != null) {
                    // return it as a String

                    logger.info("Result\n\n" + resultSoap);
                }

                StringReader soapResponseStringReader = new StringReader(resultSoap);
                JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                Person person = (Person) unmarshaller.unmarshal(soapResponseStringReader);
                logger.info("Person Result:" + person.getAddress());



            } catch (JAXBException jaxbException){
                logger.error("JAXBException -- Internal Block - JAXBContext.newInstance: ", jaxbException);
            } finally {
                response.close();
            }

        } catch (IOException ioException){
            logger.error("IOException -- Block General - for httpClient.execute: ", ioException);
        } finally {
            try {
                httpClient.close();
            } catch(IOException ioException){
                logger.error("IOException -- httpClient.close()", ioException);
            }
        }
    }
}
