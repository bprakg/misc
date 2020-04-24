package com.rand;

import javax.xml.ws.Endpoint;

public class RandPublisher {

	public static void main(String[] args) {

		final String url = "http://localhost:8888/rs";
		System.out.println("publishing Randservice at " + url);
		Endpoint.publish(url, new RandImpl());
	}
}
