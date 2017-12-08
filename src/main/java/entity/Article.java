package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {

	@Id
	private Integer id;
	
	@Column(name="refer")
	private String reference;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="prix")
	private Double prix;
	
	@ManyToOne
	@JoinColumn(name="id_fou")
	private Fournisseur fournisseur;
	
	@ManyToMany(mappedBy="listeArticle")
	private List<BonCommande> listeBonCommande;
	
	@Override
	public String toString() {
		return "Article n° "+this.id+" => reference: "+this.reference+", designation: "+this.designation+", prix: "+this.prix+", Fournisseur: "+this.fournisseur;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Fournisseur getIdFournisseur() {
		return fournisseur;
	}
	public void setIdFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
}
