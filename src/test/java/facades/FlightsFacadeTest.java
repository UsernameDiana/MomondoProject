package facades;

import entities.Flights;
import java.util.List;
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
     * Test of getWithAll method, of class FlightsFacade.*/
   
    @Test
    public void testGetWithAll() {
        String date = "2016-11-11T06:50:00.000Z"; 
        List<Flights> flights = facade.getWithAll("CPH", "RIX", date, 2);
        assertEquals(1, flights.size());
    }
  
    @Test
    public void testGetWithThree(){
        String date = "2016-11-11T06:50:00.000Z"; 
        List<Flights> flights = facade.getWithThree("CPH", date, 2);
        assertEquals(1, flights.size());
    }
    
    /**
     * Test of getWithTwo method, of class FlightsFacade.
     */
    @Test
    public void testGetWithTwo() {
        List<Flights> flights = facade.getWithTwo("CPH", "CDG");
        assertEquals(1, flights.size());  // returns the number of elements in this list
    }

    /**
     * Test of getWithDate method, of class FlightsFacade.
     */
    @Test
    public void testGetWithDate() {
        List<Flights> flights = facade.getWithDate("2016-03-05T09:00:00.000Z");
        assertEquals(1, flights.size());
    }
//
//    /**
//     * Test of getWithOrigin method, of class FlightsFacade.
//     */

    @Test
    public void testGetWithOrigin() {
        List<Flights> flights = facade.getWithOrigin("CPH", "2016-03-05T09:00:00.000Z");
        assertEquals(1, flights.size());
    }

}
