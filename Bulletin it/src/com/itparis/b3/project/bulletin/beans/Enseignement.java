package com.itparis.b3.project.bulletin.beans;

public class Enseignement {

	private String idEtudiant;
	private String idModule;
	
	public Enseignement(String idEtudiant, String idModule){
		
		this.idEtudiant = idEtudiant;
		this.idModule = idModule;
	}
	
	public Enseignement(){
		this("","");
	}

	public String getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(String idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getIdModule() {
		return idModule;
	}

	public void setIdModule(String idModule) {
		this.idModule = idModule;
	}

	@Override
	public String toString() {
		return "Enseignement [idEtudiant=" + idEtudiant + ", idModule="
				+ idModule + "]";
	}
}
