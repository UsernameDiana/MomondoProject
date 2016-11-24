/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @Override
    public List<Flights> getWithAll(String origin, String dest, String date) {
        EntityManager em = getEntityManager();
        try {
            Query query = /*em.createNamedQuery("Flights.findWithAll", Flights.class)
                    .setParameter("f.origin", origin).setParameter("destination", dest)
                    .setParameter("f.date", date);*/
                    em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" 
                            + origin + "'" + "AND f.destination = '" + dest + "'" + "AND f.date = '" + date + "'");
            List<Flights> f = query.getResultList();
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
                    em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" 
                            + origin + "'" + "AND f.destination = '" + dest + "'");
            List<Flights> f = query.getResultList();
            return f;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Flights> getWithDate(String date) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Flights.findWithDate", Flights.class)
                    .setParameter("f.date", date);
            List<Flights> f = query.getResultList();
            return f;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Flights> getWithOrigin(String origin, String date) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Flights.findWithOrigin", Flights.class)
                    .setParameter("f.origin", origin);
            List<Flights> f = query.getResultList();
            return f;
        } finally {
            em.close();
        }
    }

}
