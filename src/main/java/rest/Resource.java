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
    @Path("/{origin}/{date}/{tickits}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFromDateTickits(@PathParam("origin") String origin, 
            @PathParam("date") String date, @PathParam("tickits") String tickets) {
        
        List<Flights> f = facade.getWithThree(origin, date, tickets);
        System.out.println("GET WITH TWO PARAMS" + f);
        return gson.toJson(f);
    }
    
    @GET
    @Path("/{origin}/{destination}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFlightsAllParams(@PathParam("origin") String origin,
            @PathParam("destination") String dest, @PathParam("date") String date, @PathParam("tickets") String tickets) {
        List<Flights> f = facade.getWithAll(origin, dest, date, tickets);
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
        System.out.println("GET WITH TWO PARAMS" + f);
        return gson.toJson(f);
    }
}
