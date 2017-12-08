/**
 * 
 */
package jpa;

import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.Entity;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import entity.Article;

/**
 * @author ETY0005
 *
 */
public class TestJpa {

    public static void main( String[] args ) {
        
    	/* Creation d'une instance d'entityManagerFactory */
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-jpa");
    	
    	/* Creation d'une instance d'entityManager */
    	EntityManager em = emf.createEntityManager();
    	
    	/* Extraction de tous les articles  */
    	TypedQuery<Article> query = em.createQuery("select a from Article a where a.reference='F01'",Article.class);
    	Article a1 = query.getResultList().get(0);
    	Article a2 = query.getResultList().get(1);
    	
    	/* affichage de la requete d'extraction */
    	System.out.println(a1.getDesignation());
    	System.out.println(a2.getDesignation());
    	
    	em.clear();
    	em.close();
    	emf.close();
    	
    	
    }
	
}
