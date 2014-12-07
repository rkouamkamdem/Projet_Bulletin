package com.itparis.b3.project.bulletin.beans;

public class Matiere {

	private String id;
	private String nom;
	private String idModule;
	private String Coefficient;
	//private String Test;
	public Matiere(String id, String nom, String idModule,String Coefficient){
		
		this.id = id;
		this.nom = nom;
		this.idModule = idModule;
		this.Coefficient = Coefficient;
	}
	
	public Matiere(String id){
		
		this(id,"","","");
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

	public String getCoefficient() {
		return Coefficient;
	}

	public void setCoefficient(String coefficient) {
		Coefficient = coefficient;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", idModule=" + idModule
				+ ", Coefficient=" + Coefficient + "]";
	}	
}
