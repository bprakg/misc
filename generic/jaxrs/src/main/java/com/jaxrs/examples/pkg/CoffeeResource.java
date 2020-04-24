package com.jaxrs.examples.pkg;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/coffee")
public class CoffeeResource {

	public static List<String> orders = new ArrayList<>();

	@GET
	@Path("orders")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoffeeList() {
		System.out.println("count= " + orders.size());
		System.out.println("orders= " + orders);
		return Response.;
	}

	@POST
	@Path("/{coffee}")
	public void addCoffee(@PathParam("coffee") String coffee) {
		System.out.println("Adding " + coffee);
		orders.add(coffee);
		System.out.println("count= " + orders.size());
		System.out.println("orders= " + orders);
	}
}
