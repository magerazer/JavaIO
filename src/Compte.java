

import java.io.Serializable;
import java.time.LocalDate;

public class Compte implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String nom;
	private String prenom;	
	private int age;		
	private String mail;
	private LocalDate anneeNaissance;
	
	public Compte() {
	}
	
	public Compte(String mail, String nom, String prenom, LocalDate anneeNaissance) {
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.anneeNaissance = anneeNaissance;
	}

	public LocalDate getAnneeNaissance() {
		return anneeNaissance;
	}

	public void setAnneeNaissance(LocalDate anneeNaissance) {
		this.anneeNaissance = anneeNaissance;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Compte [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", mail=" + mail + ", anneeNaissance="
				+ anneeNaissance + "]";
	}
	
	
	
	
	
}
