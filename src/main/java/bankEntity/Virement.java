package bankEntity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

	private String beneficiaire;

	public Virement() {

	}
	
	public Virement(LocalDate date, Double montant, String motif, Compte compte, String beneficiaire) {
		super(date,montant,motif,compte);
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}
