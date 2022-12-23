package com.stevenprogramming.javaee.wsdl.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface PersonService {

    @WebMethod
    Person findByName(String name);
}
