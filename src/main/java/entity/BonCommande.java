package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bon")
public class BonCommande {
	
	@Id
	private Integer id;
	
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="date_cmde")
	private LocalDate date_cmde;
	
	@Column(name="delai")
	private Integer delai;
	
	@ManyToOne
	@JoinColumn(name="id_fou")
	private Fournisseur fournisseur;
	
	@ManyToMany
	@JoinTable(name = "compo",
		joinColumns = @JoinColumn(name="id_bon",referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="id_art",referencedColumnName="id")
	)
	private List<Article> listeArticle;
	
	@Override
	public String toString() {
		return "Bon n° "+this.id+" => numero: "+this.numero+", dateCommande: "+this.date_cmde+", delai: "+this.delai+", Fournisseur: "+this.getFournisseur()+", Articles: "+this.getListeArticle();
	}
	
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public List<Article> getListeArticle() {
		return listeArticle;
	}
	public void setListeArticle(List<Article> listeArticle) {
		this.listeArticle = listeArticle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public LocalDate getDate_cmde() {
		return date_cmde;
	}
	public void setDate_cmde(LocalDate date_cmde) {
		this.date_cmde = date_cmde;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	public Fournisseur getIdfou() {
		return fournisseur;
	}
	public void setIdfou(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
}
