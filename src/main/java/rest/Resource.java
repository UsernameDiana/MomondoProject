package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Flights;
import facades.FlightsFacade;
import facades.IFlights;
import java.io.IOException;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 */
@Path("search")
public class Resource {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static IFlights facade = new FlightsFacade(Persistence.createEntityManagerFactory("pu"));
    private final String airline = "airline : Group C6 Airline";
    private final String flights = "Flights : ";
    @Context
    private UriInfo context;

    public Resource() {
    }

    @GET
    @Path("/{origin}/{date}/{tickets}")
    public String getWithThree(@PathParam("origin") String origin, 
            @PathParam("date") String date, @PathParam("tickets") String tickets) {
       
        List<Flights> f = facade.getWithThree(origin, date, tickets); 
        System.out.println("REST - GET WITH THREE PARAMS" + f);
        return flights + gson.toJson(f);
    }
    
    @GET
    @Path("/{origin}/{destination}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFlightsAllParams(@PathParam("origin") String origin,
            @PathParam("destination") String dest, @PathParam("date") String date , @PathParam("tickets") String tickets) throws IOException{
        
        List<Flights> f = facade.getWithAll(origin, dest, date, tickets );
        System.out.println("REST GET WITH ALL");
        return airline + " " + flights + gson.toJson( f);
    }
    
    @POST
    @Path("{reservation}/{flightId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String reservation(@PathParam("reservation") String reservation, @PathParam("flightId") String flightId)
    {
        return null;
    }
    
     /** Retrieves representation of an instance of rest.Resource
     * @param origin
     * @param date
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{origin}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFlightsTwoParams(@PathParam("origin") String origin, @PathParam("date") String date) 
    {  
        List<Flights> f = facade.getWithTwo(origin, date);
        return flights + gson.toJson( f);
    }
}
