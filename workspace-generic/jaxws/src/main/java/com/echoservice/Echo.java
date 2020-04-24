package com.echoservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Echo {
    @WebMethod
    public String echo(String msg) { return "Echoing: " + msg; }
}

