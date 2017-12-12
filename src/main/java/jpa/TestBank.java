/**
 * 
 */
package jpa;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bankEntity.Adresse;
import bankEntity.AssuranceVie;
import bankEntity.Banque;
import bankEntity.Client;
import bankEntity.Compte;
import bankEntity.LivretA;
import bankEntity.Operation;
import bankEntity.Virement;

/**
 * @author ETY0005
 *
 */
public class TestBank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-jpa");
    	EntityManager em = emf.createEntityManager();
    	
    	Banque bank = new Banque("Banque Pas Populaire");
    	Client p1 = new Client("Berra", "Moha", LocalDate.of(1991, 07, 14), new Adresse(40,"rue du Maroc",72000,"Le Mans"), bank);
    	Client p2 = new Client("Beagel", "Alex", LocalDate.parse("1994-10-24"), new Adresse(55,"rue des morillons",93120,"Montreuil"), bank);
    	Client p3 = new Client("Oumachi", "Ban", LocalDate.parse("1990-11-08"), new Adresse(10,"avenue de la libération",92000,"Montrouge"), bank);
    	Compte c1 = new LivretA("465456341",55555.,2.8);
    	Compte c2 = new LivretA("684554455",423.4,2.2);
    	Compte c3 = new AssuranceVie("736786578",12.23,LocalDate.parse("2020-12-31"),1.1);
    	Compte c4 = new AssuranceVie("141427555",4275.3,LocalDate.parse("2022-12-31"),1.2);
    	Operation op1 = new Virement(LocalDate.parse("2018-01-01"),3333.,"Redevance bancaire",c1,"Banque Pas Populaire");
    	Operation op2 = new Virement(LocalDate.parse("2018-01-01"),222.2,"facture EDF",c2,"EDF");
    	Operation op3 = new Virement(LocalDate.parse("2018-01-01"),142.1,"facture EAU",c3,"EDF");
    	Operation op4 = new Virement(LocalDate.parse("2018-01-01"),71.1,"facture Telephonique",c3,"Orange");
    	Operation op5 = new Virement(LocalDate.parse("2018-01-01"),33.3,"Incidents bancaire",c4,"Banque Pas Populaire");
    	
    	bank.getClients().add(p1);
    	bank.getClients().add(p2);
    	bank.getClients().add(p3);
    	
    	c1.getOperations().add(op1);
    	c2.getOperations().add(op2);
    	c3.getOperations().add(op3);
    	c3.getOperations().add(op4);
    	c4.getOperations().add(op4);
    	c4.getOperations().add(op5);
    	
    	p1.getComptes().add(c1);
    	p1.getComptes().add(c2);
    	p2.getComptes().add(c3);
    	p3.getComptes().add(c4);
    	
    	c1.getClients().add(p1);
    	c2.getClients().add(p1);
    	c3.getClients().add(p2);
    	c4.getClients().add(p3);
    	
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.persist(bank);
    	em.persist(p1);
    	em.persist(p2);
    	em.persist(p3);
    	em.persist(c1);
    	em.persist(c2);
    	em.persist(c3);
    	em.persist(c4);
    	em.persist(op1);
    	em.persist(op2);
    	em.persist(op3);
    	em.persist(op4);
    	em.persist(op5);
    	
    	et.commit();
    

    	
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
    	
    	em.close();
    	emf.close();
		
	}

}
