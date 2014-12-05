package com.itparis.b3.project.bulletin.beans;

public class Matiere {

	private String id;
	private String nom;
	private String idModule;
	
	public Matiere(String id, String nom, String idModule){
		
		this.id = id;
		this.nom = nom;
		this.idModule = idModule;
	}
	
	public Matiere(String id){
		
		this(id,"","");
	}
	
	public Matiere(){
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

	public String getIdModule() {
		return idModule;
	}

	public void setIdModule(String idModule) {
		this.idModule = idModule;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", idModule=" + idModule
				+ "]";
	}
}
