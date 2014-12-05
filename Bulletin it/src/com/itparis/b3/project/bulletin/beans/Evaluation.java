package com.itparis.b3.project.bulletin.beans;

public class Evaluation {

	private String idEtudiant;
	private String idModule;
	
	public Evaluation(String idEtudiant, String idModule){
		
		this.idEtudiant = idEtudiant;
		this.idModule = idModule;
	}
	
	public Evaluation(){
		
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
		return "Evaluation [idEtudiant=" + idEtudiant + ", idModule="
				+ idModule + "]";
	}
}
