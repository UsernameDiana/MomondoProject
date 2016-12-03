package facades;

import entities.Flights;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;
/**
 *
 * @author jarmo
 */
public class FlightsFacade implements IFlights {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public FlightsFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override // from / date / ticets
    public List<Flights> getWithThree(String origin, String date, String tickets){
        EntityManager em = getEntityManager();
        try{
             Query query = em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" 
                            + origin + "'" + "AND f.date = '" + date + "'" + "AND f.tickets = '" + tickets + "'");
            List<Flights> f = query.getResultList();
            return f;
        }
        finally{}
    
    }
    
    @Override  // from / to / date / tickets
    public List<Flights> getWithAll(String origin, String dest, String date, String tickets) {
        EntityManager em = getEntityManager();
        try {
            Query query = /*em.createNamedQuery("Flights.findWithAll", Flights.class)
                    .setParameter("f.origin", origin).setParameter("destination", dest)
                    .setParameter("f.date", date);*/
            em.createQuery("SELECT f FROM Flights f WHERE f.origin = '"+ origin +"'"+"AND f.destination ='"
                    + dest + "'" + "AND f.date ='"+ date + "AND f.numberOfSeats ='" + tickets + "'");
            List<Flights> f = query.getResultList();
            System.out.println(f + "GET WITH ALL");
            return f;
        } finally {
            em.close();
        }

    }

    @Override
    public List<Flights> getWithTwo(String origin, String dest) {
        EntityManager em = getEntityManager();
        try {
            Query query = /*em.createNamedQuery("Flights.findWithTwo", Flights.class)
                    .setParameter("f.origin", origin).setParameter("f.destination", dest);*/ 
            em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" + origin + "'" + "AND f.destination ='" + dest + "'");
            List<Flights> f = query.getResultList();
            System.out.println(f + "THIS IS MY LIST OF GET WITH ORIGIN AND DATE");
            return f;
        } finally {
            em.close();
        }
    }
 
    @Override
    public List<Flights> getWithDate(String date) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT f FROM Flights f WHERE f.date = '" + date + "'");
            List<Flights> f = query.getResultList();
            System.out.println(f + "THIS IS MY LIST OF GET WITH A DATE");
            return f;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Flights> getWithOrigin(String origin, String date) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" 
                    + origin + "'" + "AND f.date = '" + date + "'");
            List<Flights> f = query.getResultList();
            System.out.println(f + "THIS IS MY LIST OF GET WITH ORIGIN AND DATE");
            return f;
        } finally {
            em.close();
        }
    }
}
