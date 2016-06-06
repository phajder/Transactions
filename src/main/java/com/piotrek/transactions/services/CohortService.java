package com.piotrek.transactions.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Provides Cohort services.
 * Answers on coordinator questions about transaction.
 *
 * @author Piotrek
 */
@Path("/cohort")
public class CohortService {

    /**
     * Method provided for testing
     * @return HttpResponse Just a simple plain text
     */
    @GET
    @Path("/hello")
    public Response sayHello() {
        return Response.status(200).entity("Hello, I'm cohort.").build();
    }
}
