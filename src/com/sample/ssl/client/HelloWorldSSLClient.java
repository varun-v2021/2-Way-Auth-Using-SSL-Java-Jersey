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

public class HelloWorldSSLClient {
	
	static
	{
		System.setProperty("javax.net.debug", "all");
		System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
		System.setProperty("https.protocols", "TLSv1.2");
		System.setProperty("javax.net.ssl.trustStore", "D://SSL_Cert//MyClient.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		System.setProperty("javax.net.ssl.keyStore",  "D://SSL_Cert//MyClient.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				new javax.net.ssl.HostnameVerifier() {
 
					public boolean verify(String hostname,
							javax.net.ssl.SSLSession sslSession) {
						if (hostname.equals("localhost")) {
							return true;
						}
						return false;
					}
				});
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		//System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class));
		System.out.println(target.request().accept(MediaType.TEXT_PLAIN).get(String.class));
		//System.out.println(target.request());
	}

	private static URI getBaseURI() {
		// here 8443 is the TLS port for secured communication based on TLS handshake
		return UriBuilder.fromUri("https://localhost:8443/SSLAppSample/helloworld").build();
	}

}
