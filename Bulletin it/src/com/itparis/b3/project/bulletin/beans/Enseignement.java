package com.itparis.b3.project.bulletin.beans;

public class Enseignement {

	private String idMatiere;
	private String idProfesseur;
	
	public Enseignement(String idEtudiant, String idModule){
		
		this.idMatiere = idMatiere;
		this.idProfesseur = idProfesseur;
	}
	
	public Enseignement(){
		this("","");
	}

	public String getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(String idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getIdProfesseur() {
		return idProfesseur;
	}

	public void setIdProfesseur(String idProfesseur) {
		this.idProfesseur = idProfesseur;
	}

	@Override
	public String toString() {
		return "Enseignement [idMatiere=" + idMatiere + ", idProfesseur="
				+ idProfesseur + "]";
	}

	
}
