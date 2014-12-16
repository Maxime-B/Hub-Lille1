package ipint.glp.donnees;

import ipint.glp.interfaces.Publication;

import java.util.Date;



public class Evenement implements Publication {

	private String titre;
	private Date date;
	private String lieu;
	private String description;
	private Utilisateur utilisateur;
	
	public Evenement(){
		super();
	}
	
	public Evenement(String titre, Date date, String lieu, String description,Utilisateur utilisateur){
		super();
		this.titre= titre;
		this.date= date;
		this.lieu= lieu;
		this.description= description;
		this.utilisateur = utilisateur;
	
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}