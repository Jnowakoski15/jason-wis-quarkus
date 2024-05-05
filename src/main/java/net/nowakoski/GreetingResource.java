package net.nowakoski;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "GREETING", defaultValue = "Hello")
    String greeting;

    @Inject
    HealthService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greeting + " from RESTEasy Reactive";
    }

    @GET
    @Path("/down")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloDown() {
        service.setStatusDown();
        return "Status is set to down!";
    }

}