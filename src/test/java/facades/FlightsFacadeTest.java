/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Flights;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jarmo
 */
public class FlightsFacadeTest {
    
    public FlightsFacadeTest() {
    }
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static IFlights facade = new FlightsFacade(emf); 
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        Date date = new Date(2016-03-05);
        try {
        em.getTransaction().begin();
        em.createQuery("delete from Flights").executeUpdate();
        Flights f1 = new Flights("2257-1457179200000","COL2257", date,3,180,120,"CPH","CDG");
        em.getTransaction().commit();
        } 
        finally {
        em.close();
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addEntityManagerFactory method, of class FlightsFacade.
     */
    //@Test
    /*
    public void testAddEntityManagerFactory() {
        System.out.println("addEntityManagerFactory");
        EntityManagerFactory emf = null;
        FlightsFacade instance = null;
        instance.addEntityManagerFactory(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getWithAll method, of class FlightsFacade.
     */
    @Test
    public void testGetWithAll() {
        Date date = new Date(2016-03-05);
     List<Flights> flights = facade.getWithAll("CPH", "CDG", date);
     assertEquals(1, flights.size());
    }

    /**
     * Test of getWithTwo method, of class FlightsFacade.
     */
    @Test
    public void testGetWithTwo() {
        Date date = new Date(2016-03-05);
     List<Flights> flights = facade.getWithAll("CPH", "CDG", date);
     assertEquals(1, flights.size());
    }

    /**
     * Test of getWithDate method, of class FlightsFacade.
     */
    @Test
    public void testGetWithDate() {
        System.out.println("getWithDate");
        Date date = null;
        FlightsFacade instance = null;
        List<Flights> expResult = null;
        List<Flights> result = instance.getWithDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWithOrigin method, of class FlightsFacade.
     */
    @Test
    public void testGetWithOrigin() {
        System.out.println("getWithOrigin");
        String origin = "";
        Date date = null;
        FlightsFacade instance = null;
        List<Flights> expResult = null;
        List<Flights> result = instance.getWithOrigin(origin, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
