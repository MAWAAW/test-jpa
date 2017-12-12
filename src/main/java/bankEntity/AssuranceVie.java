package bankEntity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	
	private LocalDate dateFin;
	
	private Double taux;
	
	public AssuranceVie() {

	}

	public AssuranceVie(String numero, Double solde, LocalDate dateFin, Double taux) {
		super(numero,solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
