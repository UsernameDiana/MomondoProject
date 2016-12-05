package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Flights;
import facades.FlightsFacade;
import facades.IFlights;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jarmo
 */
@Path("flights")
public class Resource {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static IFlights facade = new FlightsFacade(Persistence.createEntityManagerFactory("pu"));
    private final String airline = "Group C6 Airline";
    @Context
    private UriInfo context;

   
    public Resource() {
    }

    @GET
    @Path("/{origin}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFromDateTickets(@PathParam("origin") String origin, 
            @PathParam("date") String date, @PathParam("tickets") int tickets) {
       
        List<Flights> f = facade.getWithThree(origin, date, tickets);
        System.out.println("GET WITH TWO PARAMS" + f);
        return gson.toJson(f);
    }
    
    @GET
    @Path("/{origin}/{destination}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFlightsAllParams(@PathParam("origin") String origin,
            @PathParam("destination") String dest, @PathParam("date") String date, @PathParam("tickets") String tickets) {
        int t = Integer.parseInt(tickets);
        List<Flights> f = facade.getWithAll(origin, dest, date, t);
        return gson.toJson(f);
    }
    
     /** Retrieves representation of an instance of rest.Resource
     * @param origin
     * @param destination
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{origin}/{destination}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFlightsTwoParams(@PathParam("origin") String origin, 
            @PathParam("destination") String destination) {
        
        List<Flights> f = facade.getWithTwo(origin, destination);
        return gson.toJson(f);
    }
}
