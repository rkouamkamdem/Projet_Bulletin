package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.itparis.b3.project.bulletin.beans.*;
import com.itparis.b3.project.bulletin.connection.DBAction;

public class ProfesseurDAO {

	private static Professeur profTemp;
	private static ArrayList<Professeur> listTemp;
	
	public static ArrayList<Professeur> getAllProfesseurs() throws SQLException{
		
		listTemp = new ArrayList<Professeur>();
		profTemp = new Professeur();
		
		String req = "SELECT * FROM Professeur";

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			profTemp.setId(DBAction.getRes().getString(1));
			profTemp.setNom(DBAction.getRes().getString(2));
			profTemp.setPrenom(DBAction.getRes().getString(3));
			profTemp.setEmail(DBAction.getRes().getString(4));
					
			listTemp.add(new Professeur(profTemp.getId(),profTemp.getNom(),profTemp.getPrenom(), profTemp.getEmail()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static Professeur getProfesseurById(String id) throws SQLException{
		
		profTemp = new Professeur();
		
		String req = "SELECT * FROM Professeur WHERE id="+id;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		DBAction.getRes().next();
		
		profTemp.setId(DBAction.getRes().getString(1));
		profTemp.setNom(DBAction.getRes().getString(2));
		profTemp.setPrenom(DBAction.getRes().getString(3));
		profTemp.setEmail(DBAction.getRes().getString(4));
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return profTemp;
	}
	
	public static ArrayList<Professeur> getProfesseursByNomPrenom(String nom, String prenom) throws SQLException{
		
		listTemp = new ArrayList<Professeur>();
		profTemp = new Professeur();
		
		String req = "SELECT * FROM Professeur WHERE nom="+nom+" AND prenom="+prenom;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			profTemp.setId(DBAction.getRes().getString(1));
			profTemp.setNom(DBAction.getRes().getString(2));
			profTemp.setPrenom(DBAction.getRes().getString(3));
			profTemp.setEmail(DBAction.getRes().getString(4));
					
			listTemp.add(new Professeur(profTemp.getId(),profTemp.getNom(),profTemp.getPrenom(), profTemp.getEmail()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static ArrayList<Professeur> getProfesseursByEmail(String eMail) throws SQLException{
		
		listTemp = new ArrayList<Professeur>();
		profTemp = new Professeur();
		
		String req = "SELECT * FROM Professeur WHERE eMail="+eMail;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			profTemp.setId(DBAction.getRes().getString(1));
			profTemp.setNom(DBAction.getRes().getString(2));
			profTemp.setPrenom(DBAction.getRes().getString(3));
			profTemp.setEmail(DBAction.getRes().getString(4));
					
			listTemp.add(new Professeur(profTemp.getId(),profTemp.getNom(),profTemp.getPrenom(), profTemp.getEmail()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static int insertProfesseur(String id, String nom, String prenom, String eMail){
		
		int result = -1;
		DBAction.DBConnexion();
		
		String req = "INSERT INTO Etudiant (ID, NOM, PRENOM, EMAIL)VALUES(\""+id+"\",\""+nom+"\",\""+prenom+"\""+eMail+"\")";
		 
		try {
				result = DBAction.getStm().executeUpdate(req);
				System.out.println("Requete executee");
			 
			} catch (SQLException ex) {
				result = - ex.getErrorCode();
			}
		DBAction.DBClose();
		
		return result;
	}
	
	public static int deleteProfesseurById(int id) {
		
		int result = -1;
		DBAction.DBConnexion();
		 
		String req = "DELETE FROM Professeur WHERE ID =\"" + id+"\"";
		
		try {
				result = DBAction.getStm().executeUpdate(req);
				System.out.println("Requete executee");
			 
			} catch (SQLException ex) {
				result = - ex.getErrorCode();
			}
		
		DBAction.DBClose();
		
		return result;
	}
	
	public static int updateProfesseurById(String id, String nom, String prenom, String eMail){
		
		int result = -1;
		DBAction.DBConnexion();
		 
		String req = "UPDATE Professeur SET nom ="+nom+", prenom="+prenom+", eMail="+eMail+" WHERE id =\"" + id+"\"";
		
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
