package facades;

import entities.Flights;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;


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
            Query query = em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" + origin + "'" + 
                                                                        "AND f.date = '" + date + "'" + 
                                                             "AND f.numberOfSeats >= '" + tickets + "'");
            // A LIST WITH ALL FLIGHTS WITH ORIGIN/DATE THAT HAVE AVALABLE SEATS/TICKETS
            List<Flights> flightList = query.getResultList(); 
            int t = Integer.parseInt(tickets);
            for (Flights element : flightList)
            {
                element.setNumberOfSeats(t);
            }       
            return flightList;
        }
        finally{}
    }
    
    
    @Override  // from / to / date / tickets
    public List<Flights> getWithAll(String origin, String dest, String date, String tickets)throws ProtocolException, IOException  {
        EntityManager em = getEntityManager();   
        try {
            Query query = /*em.createNamedQuery("Flights.findWithAll", Flights.class)
                    .setParameter("f.origin", origin).setParameter("destination", dest)
                    .setParameter("f.date", date);*/
            em.createQuery("SELECT f FROM Flights f WHERE f.origin ='" + origin + "'" + 
                                                 "AND f.destination ='"+ dest + "'" + 
                                                 "AND f.date ='" + date + "'" +
                                                 "AND f.totalPrice >='" + tickets + "'");
            List<Flights> f = query.getResultList();
            int t = Integer.parseInt(tickets);
            for (Flights e : f)
            {
                e.setNumberOfSeats(t);
            }      
            return f;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Flights> getWithTwo(String origin, String date) {
        EntityManager em = getEntityManager();
        try {
            Query query = /*em.createNamedQuery("Flights.findWithTwo", Flights.class)
                    .setParameter("f.origin", origin).setParameter("f.destination", dest);*/ 
            em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" + origin + "'" + 
                                                        "AND f.date ='" + date + "'");
            List<Flights> f = query.getResultList();
            for (Flights e:f)
            {
                System.out.println("Facade -Flight number of seats" + e.getNumberOfSeats());
                System.out.println("Facade -Date" + e.getDate());
            }
            System.out.println(f + "Facade -THIS IS MY LIST OF GET WITH ORIGIN AND DATE");
            return f;
        } finally {
            em.close();
        }
    }
}
