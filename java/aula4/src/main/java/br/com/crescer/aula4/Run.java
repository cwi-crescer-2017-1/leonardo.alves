package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;



/**
 *
 * @author leonardo.alves
 */
public class Run {

    public static void main(String[] args) {
        final EntityManager entityManager;
        final EntityManagerFactory emf;
       
        
     
        
        emf = Persistence.createEntityManagerFactory("CRESCER");        
        entityManager = emf.createEntityManager();        
        
        Session session = entityManager.unwrap(Session.class);        
        session.load(Cliente.class, 1);
        
        
    }
}
