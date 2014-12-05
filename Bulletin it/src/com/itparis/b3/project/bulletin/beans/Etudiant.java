package com.itparis.b3.project.bulletin.beans;

public class Etudiant {

	private String id;
	private String nom;
	private String prenom;
	private String classe;
	private String promo;
	private String idTuteur;
	
	public Etudiant(String id, String nom, String prenom, String classe, String promo, String idTuteur){
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.promo = promo;
		this.idTuteur = idTuteur;
	}
	
	public Etudiant(String id){
		
		this(id,"","","","","");
	}
	
	public Etudiant(){
		
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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public String getIdTuteur() {
		return idTuteur;
	}

	public void setIdTuteur(String idTuteur) {
		this.idTuteur = idTuteur;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", classe=" + classe + ", promo=" + promo + ", idTuteur="
				+ idTuteur + "]";
	}
	
	
}
