/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jarmo
 */
@Entity
@Table(name = "flights")
@NamedQueries({
@NamedQuery(name="flights.findWithAll", query="SELECT f FROM Flights f WHERE f.date = :date AND f.origin = :origin AND f.destination = :destination"),
@NamedQuery(name="flights.findWithTwo", query="SELECT f FROM Flights f WHERE f.origin = :origin" + 
        " AND f.destination = :destination"),
@NamedQuery(name="flights.findWithDate", query="SELECT f FROM Flights f WHERE f.date = :date"),
@NamedQuery(name="flights.findWithOrigin", query="SELECT f FROM Flights f WHERE f.origin = :origin")
})
public class Flights implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "flightId")
    private String flightId;
    @Column(name = "flightNumber")
    private String flightNumber;
    @Column(name = "date")
    private Date date;
    @Column(name = "numberOfSeats")
    private int numberOfSeats;
    @Column(name = "totalPrice")
    private Number totalPrice;
    @Column(name = "travelTime")
    private int travelTime;
    @Column(name = "origin")
    private String origin;
    @Column(name = "destination")
    private String destination;

    public String getFlightNumber() {
        return flightNumber;
    }

    public Flights() {
    }

    public Flights(String flightId, String flightNumber, Date date, 
            int numberOfSeats, Number totalPrice, int travelTime, String origin,
            String destination) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.date = date;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = totalPrice;
        this.travelTime = travelTime;
        this.origin = origin;
        this.destination = destination;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Number getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Number totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getId() {
        return flightId;
    }

    public void setId(String id) {
        this.flightId = id;
    }

}
