package com.piotrek.transactions.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Provides coordinator services.
 * Establishes state of transaction.
 *
 * @author Piotrek
 */
@Path("/coordinator")
public class CoordinatorService {

    /**
     * Method provided for testing
     * @return HttpResponse Just a simple plain text
     */
    @GET
    @Path("/hello")
    public Response sayHello() {
        return Response.status(200).entity("Hello, I'm coordinator.").build();
    }
}
