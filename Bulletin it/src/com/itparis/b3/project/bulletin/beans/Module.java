package com.itparis.b3.project.bulletin.beans;

public class Module {

	private String id;
	private String nom;
	
	public Module(String id, String nom){
		
		this.id = id;
		this.nom = nom;
	}
	
	public Module(String id){
		
		this(id,"");
	}
	
	public Module(){
		
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

	@Override
	public String toString() {
		return "Module [id=" + id + ", nom=" + nom + "]";
	}
}
