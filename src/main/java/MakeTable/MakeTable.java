/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MakeTable;

import entities.Flights;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author jarmo
 */
public class MakeTable {
    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
//        Date date = new Date(2016-03-05);
//        Date date1 = new Date(2016-05-03);
//        Date date2 = new Date(2016-07-02);
//        Date date3 = new Date(2016-11-11);
//        Date date4 = new Date(2016-12-12);
        
        Flights f = new Flights("2257-1457179200000","COL2257", "2016-03-05T09:00:00.000Z",16,180,120,"CPH","CDG"); 
        Flights f1 = new Flights("2257-1458179200000","COL2257", "2016-05-03T02:00:00.000Z",20,160,150,"CPH","HEL");
        Flights f2 = new Flights("2257-1459179200000","COL2257", "2016-07-02T13:00:00.000Z",50,280,170,"CPH","AMS");
        Flights f3 = new Flights("2257-1451179200000","COL2257", "2016-11-11T06:50:00.000Z",70,680,110,"CPH","RIX");
        Flights f4 = new Flights("2257-1452179200000","COL2257", "2016-12-12T19:10:00.000Z",100,880,10,"CPH","ICN");
        EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
        em.getTransaction().begin();
        em.persist(f);
        em.persist(f1);
        em.persist(f2);
        em.persist(f3);
        em.persist(f4);
        em.getTransaction().commit();
        
    }
   
}
