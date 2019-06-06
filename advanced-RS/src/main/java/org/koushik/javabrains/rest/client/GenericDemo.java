package org.koushik.javabrains.rest.client;

import org.koushik.javabrains.messenger.model.Message;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class GenericDemo {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		List<Message> messages = client.target("http://localhost:8080/advanced-RS/webapi/").path("/messages")
				.queryParam("year", 2015).request().get(new GenericType<List<Message>>() {
				});

		System.out.println(messages);
	}
}
