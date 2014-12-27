package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.itparis.b3.project.bulletin.connection.*;
import com.itparis.b3.project.bulletin.beans.*;
import com.mysql.jdbc.SQLError;

/**
 * 
 * @author Kouam romeo
 * @version v0.1
 * Le 24/12/2014
 */

public class TuteurDAO {
	
	/**
	 * Sélectionne un tuteur en fonction de l'identifiant passé en paramètre.
	 * @throws SQLException 
	 */
	public static Tuteur getTuteurById(String id) throws SQLException
	{
			
			Tuteur tuteurTemp = new Tuteur();
			
			String req = "SELECT * FROM Tuteur WHERE id="+id;
	
			//Connexion
			DBAction.DBConnexion();
			//Execution de la requete + init
			DBAction.setRes(DBAction.getStm().executeQuery(req));
			
			while(DBAction.getRes().next())
			{
				tuteurTemp.setId(DBAction.getRes().getString(1));
				tuteurTemp.setNom(DBAction.getRes().getString(2));
				tuteurTemp.setPrenom(DBAction.getRes().getString(3));
				tuteurTemp.setEmail(DBAction.getRes().getString(4));
			}
			//Fermeture de la connexion
			DBAction.DBClose();
			
			return tuteurTemp;
	}
	
	/**
	 * Lister l'ensemble des tuteurs existant en base
	 * @throws SQLException 
	 */
	public static ArrayList<Tuteur> getAllTuteur() throws SQLException 
	{
		
		ArrayList<Tuteur> listTemp = new ArrayList <Tuteur>();
		String req = "SELECT * FROM Tuteur";

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			Tuteur tuteurTemp = new Tuteur();
			tuteurTemp.setId(DBAction.getRes().getString(1));
			tuteurTemp.setNom(DBAction.getRes().getString(2));
			tuteurTemp.setPrenom(DBAction.getRes().getString(3));
			tuteurTemp.setEmail(DBAction.getRes().getString(4));
			
			listTemp.add(tuteurTemp);
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		return listTemp;
	}
	
	/*
	 Lister les tuteurs avec leur étudiants associés.
 	@param idTuteur
	@return : Une liste de tuteur avec leur etudiant associé
	*/
	
	public static ArrayList<Tuteur> getTuteurAndEtudiant() throws SQLException
	{
		
		ArrayList<Tuteur> listTuteurParEtudiant = new ArrayList <Tuteur>();
		
		String req = "SELECT tuteur.nom, tuteur.prenom, etudiant.nom, etudiant.prenom FROM tuteur WHERE tuteur.idtuteur IN ( SELECT tuteur_idtuteur FROM etudiant ) ";
		//Connection à la base de données
		DBAction.DBConnexion();
		
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{
			Tuteur tuteurTempParEtudiant = new Tuteur();
			//Création de l'objet temp à travers le résultat de la requete
			tuteurTempParEtudiant.setId(DBAction.getRes().getString(1));
			tuteurTempParEtudiant.setNom(DBAction.getRes().getString(2));
			tuteurTempParEtudiant.setPrenom(DBAction.getRes().getString(3));
			tuteurTempParEtudiant.setEmail(DBAction.getRes().getString(4));
			
			listTuteurParEtudiant.add(tuteurTempParEtudiant);
		}
		
		return listTuteurParEtudiant;
	}
	
	
	/**
	 * Delete tuteur par son id
	 * @param idTuteur
	 * @return : le nbr de tuteurs supprimés sinon le (-) code d'erreur  
	 */
	public static int deleteTuteurById(String idTuteur)
	{
		int result = -1;
		//Connection à la base de données
		DBAction.DBConnexion();
		
		String req = "DELETE FROM tuteur WHERE idTuteur = '"+idTuteur+"' ";
		try
		{
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executée");	
		} 
		catch (SQLException ex)
		{
			//result = - ex.getErrorCode();
			int codeE = ( (SQLException) ex).getErrorCode();
			if(SQLError.SQL_STATE_CONNECTION_REJECTED.equals(codeE))
				result = -1;
			else if (SQLError.SQL_STATE_CONNECTION_FAIL_DURING_TX.equals(codeE))
				result = -2;
			System.out.println(ex.getMessage());
		}
		System.out.println("["+req+"] Suppression : Valeur de result == "+result);
		
		//On ferme la connection
		DBAction.DBClose();
		return result;
	}
	
	/**
	 * Met à jour le profil d'un tuteur par son numéro
	 * @param num
	 * @return : le nbr de tuteurs mis à jour sinon le (-) code d'erreur  
	 */
	public static int updTuteurById(String idTuteur,String nom,String prenom,String email)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE tuteur SET nom = '"+nom+"' prenom = '"+prenom+"' email = '"+email+"' WHERE idTuteur ='"+idTuteur+"' ";
		try 
		{
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executee");	
		} catch (SQLException ex)
		{
			int codeE = ( (SQLException) ex).getErrorCode();
			if(SQLError.SQL_STATE_CONNECTION_REJECTED.equals(codeE))
				result = -1;
			else if (SQLError.SQL_STATE_CONNECTION_FAIL_DURING_TX.equals(codeE))
				result = -2;
		}
		DBAction.DBClose();
		return result;
		
	}
	
	/**
	 * Ajouter un tuteur
	 * @param String num, String nom, int age, String adresse
	 * @return : le nbr de tuteur ajouté sinon le (-) code d'erreur   
	 */
	public static int addTuteur(String idTuteur,String nom,String prenom,String email)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO tuteur (idTuteur, nom, prenom, email) VALUES ('"+idTuteur+"','"+nom+"','"+prenom+"','"+email+"') ";
		try 
		{
			result = DBAction.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			int codeE = ( (SQLException) ex).getErrorCode();
			if(SQLError.SQL_STATE_CONNECTION_REJECTED.equals(codeE))
				result = -1;
			else if (SQLError.SQL_STATE_CONNECTION_FAIL_DURING_TX.equals(codeE))
				result = -2;
		}//System.out.println("["+req+"] Valeur de result == "+result);
			
		System.out.println(req);
		
		//On ferme la connection
		DBAction.DBClose();
		return result;
		
	}
}
