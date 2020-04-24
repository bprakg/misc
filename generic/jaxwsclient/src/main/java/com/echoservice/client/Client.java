package com.echoservice.client;

import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import com.echoservice.Echo;
import com.echoservice.EchoService;

public class Client {

	public static void main(String[] args) {
		try {
			List<Handler> hchain = new LinkedList<Handler>();
			hchain.add(new ClientHandler());
			EchoService service = new EchoService();
			Echo port = service.getEchoPort();
			Binding binding = ((BindingProvider) port).getBinding();
			binding.setHandlerChain(hchain);
			String Response = port.echo("Goodbye, cruel world!");
			System.out.println("From Echo Service = " + Response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
