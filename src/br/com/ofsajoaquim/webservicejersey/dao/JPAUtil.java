package br.com.ofsajoaquim.webservicejersey.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
          if (emf == null) {
        	  //persistence.xml
               emf = Persistence.createEntityManagerFactory("webservicejerseydb");
          }
          return emf.createEntityManager();
    }
}