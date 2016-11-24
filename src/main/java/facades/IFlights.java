/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Flights;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jarmo
 */
public interface IFlights {
    
    void addEntityManagerFactory(EntityManagerFactory emf);
    public List<Flights> getWithAll(String origin, String dest, String date);
    public List<Flights> getWithTwo(String origin, String dest);
    public List<Flights> getWithDate(String date);
    public List<Flights> getWithOrigin(String origin, String date);
//    public List<Flights> getAll();
}
