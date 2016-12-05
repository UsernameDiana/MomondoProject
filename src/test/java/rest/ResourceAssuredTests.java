
package rest;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.hasItems;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResourceAssuredTests {
    
    public ResourceAssuredTests() {
    }
    

    @Test
    public void testGetOriginDateTickets() {
RestAssured.given()
        .pathParam("origin", "CPH")
        .pathParam("date", "2017-01-13T00:00:00.000Z")
        .pathParam("tickets", 2)
        .when()
        .get("http://airline-plaul.rhcloud.com/api/flightinfo/{origin}/{date}/{tickets}")
        .then()
        .body("flights.origin", hasItems("CPH"));
    }

    @Test
    public void testGetAllFlightsAllParams() {
        RestAssured.given()
                .pathParam("origin", "CPH")
                .pathParam("destination", "SXF")
                .pathParam("date", "2017-01-13T00:00:00.000Z")
                .pathParam("tickets", 1)
                .when()
                .get("http://airline-plaul.rhcloud.com/api/flightinfo/{origin}/{destination}/{date}/{tickets}")
                .then()
                .body("flights.origin", hasItems("CPH"));
    }


    @Test
    public void testGetOriginDestenation() {

    }
    
}
