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
    	
    	
    	/*TypedQuery<BonCommande> query = em.createQuery("select b from BonCommande b where b.numero=2 ",BonCommande.class);
    	BonCommande bon = query.getResultList().get(0);
    	List<Article> articles = bon.getListeArticle();
    	articles.stream().filter(a -> a.getPrix()<100).forEach(f -> LOGGER.info(f.toString()));*/
    	
    	/* Création d'un fournisseur et ajout en base  */
    	/*Fournisseur fournisseur = new Fournisseur();
    	fournisseur.setId(7);
    	fournisseur.setNom("FOU_7");
    	
    	em.getTransaction().begin();
    	em.persist(fournisseur);
    	em.getTransaction().commit();
    	*/
    	
    	/*Article article = new Article();
    	article.setId(1000001);
    	article.setReference("ref4445");
    	article.setDesignation("ibm tools");
    	article.setPrix(321.);
    	article.setIdFournisseur(fournisseur);
    	
    	BonCommande bon = new BonCommande();
    	bon.setId(7);
    	bon.setFournisseur(fournisseur);
    	
    	em.getTransaction().begin();
    	em.persist(article);
    	em.getTransaction().commit();*/
    	
    	/*TypedQuery<Article> query = em.createQuery("select b from Article b where b.reference like 'ref4445' ",Article.class);
    	List<Article> art = query.getResultList();
    	art.stream().forEach(f -> LOGGER.info(f.toString()));
    	*/
    	
    	/* Fermeture de la connexion vers la base de donnée */
    	em.close();
    	emf.close();
    	
    	
    }
}
