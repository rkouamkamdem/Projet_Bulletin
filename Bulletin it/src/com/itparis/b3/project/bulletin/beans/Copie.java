package com.itparis.b3.project.bulletin.beans;

/**
 * 
 * @author Bouveti
 * @version v0.1
 * 
 */
/*blablabla*/
	
public class Copie {

	private String id;
	private String adresse;
	private float note;
	private String idEtudiant;
	private String idMatiere;
	private String Coefficient;
	
	/**
	 * 
	 * @param id
	 * @param adresse
	 * @param note
	 * @param idEtudiant
	 * @param idMatiere
	 * @param Coefficient
	 */
	
	public Copie(String id, String adresse, float note, String idEtudiant, String idMatiere,String Coefficient){
	
	/**
	 * 
	 * @param id
	 * @param adresse
	 * @param note
	 * @param idEtudiant
	 * @param idMatiere
	 * @param Coefficient
	 */
		
		this.id = id;
		this.adresse = adresse;
		this.note = note;
		this.idEtudiant = idEtudiant;
		this.idMatiere = idMatiere;
		this.Coefficient = Coefficient;
	}
	
	/**
	 * @
	 */
	public Copie(String id){
		
		this(id,"",0.0f,"","","");
	}
	/**
	 * 
	 */
	public Copie(){
		this("");
	}

	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public String getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(String idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(String idMatiere) {
		this.idMatiere = idMatiere;
	}
	
	public String getCoefficient() {
		return Coefficient;
	}

	public void setCoefficient(String coefficient) {
		Coefficient = coefficient;
	}

	
	@Override
	public String toString() {
		return "Copie [id=" + id + ", adresse=" + adresse + ", note=" + note
				+ ", idEtudiant=" + idEtudiant + ", idMatiere=" + idMatiere + " Coefficient=" + Coefficient + "] ";
	}
}
