package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur {
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY) // Pour faire de l'auto-increment
	@Id
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="fournisseur")
	private List<Article> listeArticle; // Références vers les articles
	
	@OneToMany(mappedBy="fournisseur")
	private List<BonCommande> listeBonCommande; // Références vers les bons de commandes

	@Override
	public String toString() {
		return "{ "+this.nom+" }";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
