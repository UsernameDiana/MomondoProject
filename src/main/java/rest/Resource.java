/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Flights;
import facades.FlightsFacade;
import facades.IFlights;
import java.sql.Date;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jarmo
 */
@Path("flights")
public class Resource {

    static IFlights facade = new FlightsFacade(Persistence.createEntityManagerFactory("pu"));
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String airline = "Group C6 Airline";
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Resource
     */
    public Resource() {
    }

    /**
     * Retrieves representation of an instance of rest.Resource
     * @param origin
     * @param destination
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{origin},{destination}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFlightsTwoParams(@PathParam("origin") String origin, 
            @PathParam("destination") String destination) {
        
        List<Flights> f = facade.getWithTwo(origin, destination);
        
        return gson.toJson(f);
    }
    @GET
    @Path("/{origin},{destination},{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFlightsAllParams(@PathParam("origin") String origin,
            @PathParam("destination") String dest, @PathParam("date") String date) {
        List<Flights> f = facade.getWithAll(origin, dest, date);
        return gson.toJson(f);
    }
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getAllFlights() {
//        
//        return null;
//    }

    /**
     * PUT method for updating or creating an instance of Resource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putXml(String content) {
//    }
}
