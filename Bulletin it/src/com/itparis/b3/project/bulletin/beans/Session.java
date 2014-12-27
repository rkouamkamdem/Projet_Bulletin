package com.itparis.b3.project.bulletin.beans;

public class Session {

	private String id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private String categorie;
	private String eMail;
	
	public Session(String id, String nom, String prenom, String login, String mdp, String categorie,String eMail){
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.categorie = categorie;
		this.eMail = eMail;
	}
	
	public Session(String id){
		
		this(id,"","","","","","");
	}
	
	public Session(){
		
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getEmail() {
		return eMail;
	}

	public void setEmail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", login=" + login + ", mdp=" + mdp + ", categorie="
				+ categorie + ", eMail=" + eMail + "]";
	}
}
