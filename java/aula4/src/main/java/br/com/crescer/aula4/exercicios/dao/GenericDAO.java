
package br.com.crescer.aula4.exercicios.dao;


import br.com.crescer.aula4.exercicios.pojo.Manipulate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * @author leonardo.alves
 * @param <E> Elemento
 * @param <N> Numero, id
 **/
public abstract class GenericDAO<E, N extends Long> implements CrudDao<E, N> {
    
    private final EntityManagerFactory managerFactory;    
    private final EntityManager        entityManager;
    private final Session              session;
    private final Transaction          transaction;
    private final Class<E>             entityClass;
    
    protected GenericDAO(Class<E> entityClass){        
        this.managerFactory = Persistence.createEntityManagerFactory("CRESCER");
        this.entityManager  = this.managerFactory.createEntityManager();
        this.entityClass =  entityClass;
        this.session = entityManager.unwrap(Session.class);
        this.transaction = session.getTransaction();        
    }
    
    @Override
    public final E save(E e) {
        manipulate(Manipulate.SAVE, e);        
        return e;
    }
    
    @Override
    public final void remove(E e) {  
        manipulate(Manipulate.DELETE, e);
    }
    
    private void manipulate (Manipulate option, E e) {        
                
        this.transaction.begin();

        switch(option) {
            case SAVE:
                session.saveOrUpdate(e);
                break;
            case DELETE:
                session.delete(e);
                break;
        }
        
        this.transaction.commit();        
    }
    
    @Override
    public final E loadById(Long id) {
        return (E) this.session.load(this.entityClass, id);        
    }
    
    @Override
    public  final List<E> findAll() {
        Criteria criteria = 
                this.session.createCriteria(this.entityClass);
        return criteria.list();
    }
    
    @Override
    public final EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public void close () {
        this.managerFactory.close();
        this.entityManager.close();
        this.session.close();       
    }
}
