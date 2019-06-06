package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.eclipse.persistence.oxm.MediaType;
import org.koushik.javabrains.messenger.model.Message;

public class RestAPIClient {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

//         Response response=client.target("http://localhost:8080/advanced-RS/webapi/messages/1").request().get();	

		WebTarget baseTarget = client.target("http://localhost:8080/advanced-RS/webapi/");

		WebTarget messageTarget = baseTarget.path("/messages");

		WebTarget singleMessageTarget = messageTarget.path("{messageId}");

//         Message message= response.readEntity(Message.class);

		Message message = singleMessageTarget.resolveTemplate("messageId", "2").request().get(Message.class);

		Message newMessage = new Message(4, "My new Message from jax-RS client", "koushik");

		Response postResponse = messageTarget.request().post(Entity.json(newMessage));

		Message createdMessage = postResponse.readEntity(Message.class);

		System.out.println(createdMessage.getMessage());

//		System.out.println(message.getMessage());

	}
}
