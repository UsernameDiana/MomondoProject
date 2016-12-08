package facades;

import entities.Flights;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jarmo
 */
public interface IFlights {
    
    void addEntityManagerFactory(EntityManagerFactory emf);
    public List<Flights> getWithAll(String origin, String dest, String date, String tickets)throws IOException;//
    public List<Flights> getWithTwo(String origin, String date);
    public List<Flights> getWithThree(String origin, String date, String tickets);
}
    
