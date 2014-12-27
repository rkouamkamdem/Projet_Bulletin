package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.itparis.b3.project.bulletin.beans.*;
import com.itparis.b3.project.bulletin.connection.DBAction;

public class EtudiantDAO {

	
	private static Etudiant etudiantTemp;
	private static ArrayList <Etudiant> listTemp;
	
	public static ArrayList<Etudiant> getAllEtudiants() throws SQLException{
		
		listTemp = new ArrayList<Etudiant>();
		etudiantTemp = new Etudiant();
		
		String req = "SELECT * FROM Etudiant";

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			etudiantTemp.setId(DBAction.getRes().getString(1));
			etudiantTemp.setNom(DBAction.getRes().getString(2));
			etudiantTemp.setPrenom(DBAction.getRes().getString(3));
			etudiantTemp.setClasse(DBAction.getRes().getString(4));
			etudiantTemp.setPromo(DBAction.getRes().getString(5));
			etudiantTemp.setIdTuteur(DBAction.getRes().getString(6));
					
			listTemp.add(new Etudiant(etudiantTemp.getId(),etudiantTemp.getNom(),etudiantTemp.getPrenom(), etudiantTemp.getClasse(),etudiantTemp.getPromo(),etudiantTemp.getIdTuteur()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static Etudiant getEtudiantById(String id) throws SQLException{
		
		etudiantTemp = new Etudiant();
		
		String req = "SELECT * FROM Etudiant WHERE id="+id;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		DBAction.getRes().next();
		
		etudiantTemp.setId(DBAction.getRes().getString(1));
		etudiantTemp.setNom(DBAction.getRes().getString(2));
		etudiantTemp.setPrenom(DBAction.getRes().getString(3));
		etudiantTemp.setClasse(DBAction.getRes().getString(4));
		etudiantTemp.setPromo(DBAction.getRes().getString(5));
		etudiantTemp.setIdTuteur(DBAction.getRes().getString(6));
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return etudiantTemp;
	}

	public static ArrayList<Etudiant> getEtudiantsByNomPrenom(String nom, String prenom) throws SQLException{
		
		listTemp = new ArrayList<Etudiant>();
		etudiantTemp = new Etudiant();
		
		String req = "SELECT * FROM Etudiant WHERE nom="+nom+" AND prenom="+prenom;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			etudiantTemp.setId(DBAction.getRes().getString(1));
			etudiantTemp.setNom(DBAction.getRes().getString(2));
			etudiantTemp.setPrenom(DBAction.getRes().getString(3));
			etudiantTemp.setClasse(DBAction.getRes().getString(4));
			etudiantTemp.setPromo(DBAction.getRes().getString(5));
			etudiantTemp.setIdTuteur(DBAction.getRes().getString(6));
					
			listTemp.add(new Etudiant(etudiantTemp.getId(),etudiantTemp.getNom(),etudiantTemp.getPrenom(), etudiantTemp.getClasse(),etudiantTemp.getPromo(),etudiantTemp.getIdTuteur()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static ArrayList<Etudiant> getEtudiantsByClasse(String classe) throws SQLException{
		
		listTemp = new ArrayList<Etudiant>();
		etudiantTemp = new Etudiant();
		
		String req = "SELECT * FROM Etudiant WHERE classe="+classe;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			etudiantTemp.setId(DBAction.getRes().getString(1));
			etudiantTemp.setNom(DBAction.getRes().getString(2));
			etudiantTemp.setPrenom(DBAction.getRes().getString(3));
			etudiantTemp.setClasse(DBAction.getRes().getString(4));
			etudiantTemp.setPromo(DBAction.getRes().getString(5));
			etudiantTemp.setIdTuteur(DBAction.getRes().getString(6));
					
			listTemp.add(new Etudiant(etudiantTemp.getId(),etudiantTemp.getNom(),etudiantTemp.getPrenom(), etudiantTemp.getClasse(),etudiantTemp.getPromo(),etudiantTemp.getIdTuteur()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static ArrayList<Etudiant> getEtudiantsByPromo(String promo) throws SQLException{
		
		listTemp = new ArrayList<Etudiant>();
		etudiantTemp = new Etudiant();
		
		String req = "SELECT * FROM Etudiant WHERE promo="+promo;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			etudiantTemp.setId(DBAction.getRes().getString(1));
			etudiantTemp.setNom(DBAction.getRes().getString(2));
			etudiantTemp.setPrenom(DBAction.getRes().getString(3));
			etudiantTemp.setClasse(DBAction.getRes().getString(4));
			etudiantTemp.setPromo(DBAction.getRes().getString(5));
			etudiantTemp.setIdTuteur(DBAction.getRes().getString(6));
					
			listTemp.add(new Etudiant(etudiantTemp.getId(),etudiantTemp.getNom(),etudiantTemp.getPrenom(), etudiantTemp.getClasse(),etudiantTemp.getPromo(),etudiantTemp.getIdTuteur()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static ArrayList<Etudiant> getEtudiantsByTuteur(String idTuteur) throws SQLException{
		
		listTemp = new ArrayList<Etudiant>();
		etudiantTemp = new Etudiant();
		
		String req = "SELECT * FROM Etudiant WHERE idTuteur="+idTuteur;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			etudiantTemp.setId(DBAction.getRes().getString(1));
			etudiantTemp.setNom(DBAction.getRes().getString(2));
			etudiantTemp.setPrenom(DBAction.getRes().getString(3));
			etudiantTemp.setClasse(DBAction.getRes().getString(4));
			etudiantTemp.setPromo(DBAction.getRes().getString(5));
			etudiantTemp.setIdTuteur(DBAction.getRes().getString(6));
					
			listTemp.add(new Etudiant(etudiantTemp.getId(),etudiantTemp.getNom(),etudiantTemp.getPrenom(), etudiantTemp.getClasse(),etudiantTemp.getPromo(),etudiantTemp.getIdTuteur()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static int insertEtudiant(String id, String nom, String prenom, String classe, String promo, String idTuteur){
		
		int result = -1;
		DBAction.DBConnexion();
		
		String req = "INSERT INTO Etudiant (ID, NOM, PRENOM, CLASSE, PROMO, IDTUTEUR)VALUES(\""+id+"\",\""+nom+"\",\""+prenom+"\""+classe+"\""+promo+"\""+idTuteur+"\")";
		 
		try {
				result = DBAction.getStm().executeUpdate(req);
				System.out.println("Requete executee");
			 
			} catch (SQLException ex) {
				result = - ex.getErrorCode();
			}
		DBAction.DBClose();
		
		return result;
	}
	
	public static int deleteEtudiantById(int id) {
		
		int result = -1;
		DBAction.DBConnexion();
		 
		String req = "DELETE FROM Etudiant WHERE ID =\"" + id+"\"";
		
		try {
				result = DBAction.getStm().executeUpdate(req);
				System.out.println("Requete executee");
			 
			} catch (SQLException ex) {
				result = - ex.getErrorCode();
			}
		
		DBAction.DBClose();
		
		return result;
	}
	
	public static int updateEtudiantById(String id, String nom, String prenom, String classe, String promo, String idTuteur){
		
		int result = -1;
		DBAction.DBConnexion();
		 
		String req = "UPDATE ETUDIANT SET nom ="+nom+", prenom="+prenom+", classe="+classe+", promo="+promo+", idTuteur="+idTuteur+" WHERE id =\"" + id+"\"";
		
		try {
				result = DBAction.getStm().executeUpdate(req);
				System.out.println("Requete executee");
		 
			} catch (SQLException ex) {
				result = - ex.getErrorCode();
			}
		DBAction.DBClose();
		
		return result;
	}
}
