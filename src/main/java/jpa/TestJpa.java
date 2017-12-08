/**
 * 
 */
package jpa;

import java.util.List;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.*;

/**
 * @author ETY0005
 *
 */
public class TestJpa {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestJpa.class);

    public static void main( String[] args ) {
        
    	/* Creation d'une instance d'entityManagerFactory et d'entityManager */
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-jpa");
    	EntityManager em = emf.createEntityManager();
    	
    	
    	TypedQuery<BonCommande> query = em.createQuery("select b from BonCommande b where b.numero=2 ",BonCommande.class);
    	BonCommande bon = query.getResultList().get(0);
    	List<Article> articles = bon.getListeArticle();
    	articles.stream().filter(a -> a.getPrix()>100).forEach(f -> LOGGER.info(f.toString()));
    	
    	/* Extraction de tous les fournisseurs et affichage  */
    	/*TypedQuery<Fournisseur> query3 = em.createQuery("select f from Fournisseur f",Fournisseur.class);
    	List<Fournisseur> fournisseurs = query3.getResultList();
    	fournisseurs.stream().forEach(f -> LOGGER.info(f.toString()));*/
    	
    	/* Fermeture de la connexion vers la base de donnée */
    	em.close();
    	emf.close();
    	
    	
    }
	
}
