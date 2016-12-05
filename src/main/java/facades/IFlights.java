package facades;

import entities.Flights;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jarmo
 */
public interface IFlights {
    
    void addEntityManagerFactory(EntityManagerFactory emf);
    public List<Flights> getWithAll(String origin, String dest, String date, int tickets);
    public List<Flights> getWithTwo(String origin, String dest);
    public List<Flights> getWithThree(String origin, String date, int tickets);
    public List<Flights> getWithDate(String date);
    public List<Flights> getWithOrigin(String origin, String date);
}
