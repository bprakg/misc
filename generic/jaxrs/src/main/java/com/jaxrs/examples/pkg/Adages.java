package com.jaxrs.examples.pkg;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/adage")
public class Adages {
	private String[] aphorisms = {"What can be shown cannot be said.",
			"If a lion could talk, we could not understand him.",
			"Philosophy is a battle against the bewitchment of "+
			"our intelligence by means of language.",
			"Ambition is the death of thought.",
			"The limits of my language mean the limits of my world."};
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("xml")
	public Adage getXml() {
		return createAdage();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("json")
	public Adage getJson() {
		return createAdage();
	}

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("plain")
	public String getPlain() {
		return createAdage().toString()+ "\n";
	}
	
	private Adage createAdage() {
		Adage adage = new Adage();
		adage.setWords(aphorisms[new Random().nextInt(aphorisms.length)]);
		return adage;
	}
}
