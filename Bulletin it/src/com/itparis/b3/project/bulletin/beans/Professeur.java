package com.itparis.b3.project.bulletin.beans;

public class Professeur {

	private String id;
	private String nom;
	private String prenom;
	private String eMail;
	
	public Professeur(String id, String nom, String prenom, String eMail){
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.eMail = eMail;
	}
	
	public Professeur(String id){
		
		this(id,"","","");
	}
	
	public Professeur(){
		
		this("");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", eMail=" + eMail + "]";
	}
}
