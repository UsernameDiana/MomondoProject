package facades;

import entities.Flights;
import java.io.IOException;
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

    @Test
    public void testGetWithThree(){
        String date = "2016-11-11T06:50:00.000Z"; 
        List<Flights> flights = facade.getWithThree("CPH", date, "2");
        assertEquals(1, flights.size());
    }
    
     /**
     * Test of getWithAll method, of class FlightsFacade.
    */
    @Test
    public void testGetWithAll()throws IOException {
        String date = "2016-12-12T19:10:00.000Z"; 
        String origin ="CPH";
        String dest ="ICN";
        String tickets ="2"; 
        List<Flights> flights = facade.getWithAll(origin, dest, date, tickets);
        assertEquals(flights.size(), 1); 
    }

    /**
     * Test of getWithTwo method, of class FlightsFacade.
     */
    @Test
    public void testGetWithTwo() {
        List<Flights> flights = facade.getWithTwo("CPH", "2016-05-03T02:00:00.000Z");
        assertEquals(1, flights.size());  // returns the number of elements in this list
    }
}
