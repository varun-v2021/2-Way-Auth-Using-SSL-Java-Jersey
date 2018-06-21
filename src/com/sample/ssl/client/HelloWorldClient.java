package com.sample.ssl.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

//This can be run separately as well once a service is listening like HelloWorldService
// Or via browser by hitting http://localhost:8080/SSLAppSample/helloworld

public class HelloWorldClient {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		//System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class));
		System.out.println(target.request().accept(MediaType.TEXT_PLAIN).get(String.class));
	}

	private static URI getBaseURI() {
		// here server is running on 4444 port number and project name is
		// restfuljersey
		return UriBuilder.fromUri("http://localhost:8080/SSLAppSample/helloworld").build();
	}

}
