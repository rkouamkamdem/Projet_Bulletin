package com.itparis.b3.project.bulletin.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itparis.b3.project.bulletin.beans.*;
import com.itparis.b3.project.bulletin.connection.DBAction;
import com.mysql.jdbc.SQLError;

/**
 * 
 * @author Kouam romeo
 * @version v0.1
 * Le 24/12/2014
 */
public class CopieDAO 
{

	/**
	 * Lister l'ensemble des copies existantes en base
	 * @throws SQLException 
	 */
	
	public ArrayList<Copie> getAllCopies() throws SQLException
	{
		ArrayList<Copie> lstCopies = new ArrayList<Copie>();
		
		String req = "SELECT * FROM copies ";
		
		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			 Copie copieTmp = new Copie();
			 copieTmp.setId(DBAction.getRes().getString(1)) ;
			 copieTmp.setAdresse(DBAction.getRes().getString(2));
			 copieTmp.setNote(DBAction.getRes().getFloat(3));
			 copieTmp.setIdEtudiant(DBAction.getRes().getString(4));
			 copieTmp.setIdMatiere(DBAction.getRes().getString(5));
			 copieTmp.setCoefficient(DBAction.getRes().getString(6));
			
			lstCopies.add(copieTmp);
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		return lstCopies;
	}
	
	/**
	 * Sélectionne une copie en fonction de l'identifiant passé en paramètre.
	 * @param String id
	 * @return : un objet copie avec les attributs correspondant à l'Id passé en paramètre.
	 * @throws SQLException 
	 */
	public Copie getCopieById(String id) throws SQLException
	{		
		//Création de l'objet temp à travers le résultat de la requete
		 Copie copieTmp = new Copie();
		 
		String req = "SELECT * FROM copies WHERE idCopies = '"+id+"' ";
		
		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{
			 copieTmp.setId(DBAction.getRes().getString(1)) ;
			 copieTmp.setAdresse(DBAction.getRes().getString(2));
			 copieTmp.setNote(DBAction.getRes().getFloat(3));
			 copieTmp.setIdEtudiant(DBAction.getRes().getString(4));
			 copieTmp.setIdMatiere(DBAction.getRes().getString(5));
			 copieTmp.setCoefficient(DBAction.getRes().getString(6));
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return copieTmp;
	}
	
	/**
	 * Sélectionne une liste de copie en fonction de l'identifiant Etudiant passé en paramètre.
	 * @param String idEtudiant
	 * @return : une liste copie avec les attributs correspondant à l'IdEtudiant passé en paramètre.
	 * @throws SQLException 
	 */
	public ArrayList<Copie> getCopieByIdEtudiant(String idEtudiant) throws SQLException
	{	
		//Maliste de copie de copie par Etudiant.
		ArrayList<Copie> lstCopies = new ArrayList<Copie>();
		 
		String req = "SELECT * FROM copies WHERE idCopies = '"+idEtudiant+"' ";
		
		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{	
			//Création de l'objet temp à travers le résultat de la requete
			 Copie copieTmp = new Copie();
			 copieTmp.setId(DBAction.getRes().getString(1)) ;
			 copieTmp.setAdresse(DBAction.getRes().getString(2));
			 copieTmp.setNote(DBAction.getRes().getFloat(3));
			 copieTmp.setIdEtudiant(DBAction.getRes().getString(4));
			 copieTmp.setIdMatiere(DBAction.getRes().getString(5));
			 copieTmp.setCoefficient(DBAction.getRes().getString(6));
			 lstCopies.add(copieTmp);
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return lstCopies;
	}
	
	/**
	 * lister les copies par Etudiant .
	 * @param Aucun
	 * @return : une liste copie par etudiant.
	 * @throws SQLException 
	 */
	public ArrayList<Copie> getCopieByEtudiant() throws SQLException
	{	
		//Maliste de copie de copie par Etudiant.
		ArrayList<Copie> lstCopies = new ArrayList<Copie>();
		 
		String req = "SELECT * FROM copies GROUP BY etudiant_idetudiant ";
		
		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{	
			//Création de l'objet temp à travers le résultat de la requete
			 Copie copieTmp = new Copie();
			 copieTmp.setId(DBAction.getRes().getString(1)) ;
			 copieTmp.setAdresse(DBAction.getRes().getString(2));
			 copieTmp.setNote(DBAction.getRes().getFloat(3));
			 copieTmp.setIdEtudiant(DBAction.getRes().getString(4));
			 copieTmp.setIdMatiere(DBAction.getRes().getString(5));
			 copieTmp.setCoefficient(DBAction.getRes().getString(6));
			 lstCopies.add(copieTmp);
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return lstCopies;
	}
	
	/**
	 * lister les copies par Matiere_idMatiere .
	 * @param Aucun
	 * @return : une liste copie par Matiere_idMatiere.
	 * @throws SQLException 
	 */
	public ArrayList<Copie> getCopieByMatiere() throws SQLException
	{	
		//Maliste de copie de copie par Etudiant.
		ArrayList<Copie> lstCopies = new ArrayList<Copie>();
		 
		String req = "SELECT * FROM copies GROUP BY Matiere_idMatiere ";
		
		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{	
			//Création de l'objet temp à travers le résultat de la requete
			 Copie copieTmp = new Copie();
			 copieTmp.setId(DBAction.getRes().getString(1)) ;
			 copieTmp.setAdresse(DBAction.getRes().getString(2));
			 copieTmp.setNote(DBAction.getRes().getFloat(3));
			 copieTmp.setIdEtudiant(DBAction.getRes().getString(4));
			 copieTmp.setIdMatiere(DBAction.getRes().getString(5));
			 copieTmp.setCoefficient(DBAction.getRes().getString(6));
			 lstCopies.add(copieTmp);
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return lstCopies;
	}
	
	/**
	 * lister les copies par Coefficient .
	 * @param Aucun
	 * @return : une liste copie par Coefficient.
	 * @throws SQLException 
	 */
	public ArrayList<Copie> getCopieByCoefficient() throws SQLException
	{	
		//Maliste de copie de copie par Coefficient.
		ArrayList<Copie> lstCopies = new ArrayList<Copie>();
		 
		String req = "SELECT * FROM copies GROUP BY Coefficient ";
		
		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{	
			//Création de l'objet temp à travers le résultat de la requete
			 Copie copieTmp = new Copie();
			 copieTmp.setId(DBAction.getRes().getString(1)) ;
			 copieTmp.setAdresse(DBAction.getRes().getString(2));
			 copieTmp.setNote(DBAction.getRes().getFloat(3));
			 copieTmp.setIdEtudiant(DBAction.getRes().getString(4));
			 copieTmp.setIdMatiere(DBAction.getRes().getString(5));
			 copieTmp.setCoefficient(DBAction.getRes().getString(6));
			 lstCopies.add(copieTmp);
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return lstCopies;
	}
	
	/**
	 * Ajouter une Copie
	 * @param String idcopies,String adressecopie, float note,String etudiant_idetudiant,String matiere_idmatiere, String coefficient
	 * @return : le nbr de Copie ajouté sinon le (-) code d'erreur   
	 */
	public static int addCopies(String idcopies,String adressecopie, float note,String etudiant_idetudiant,String matiere_idmatiere, String coefficient)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO copies (idcopies, adressecopie, note, etudiant_idetudiant,matiere_idmatiere,coefficient) VALUES ('"+idcopies+"','"+adressecopie+"',"+note+",'"+etudiant_idetudiant+"', '"+matiere_idmatiere+"', '"+coefficient+"' ) ";
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
	
	/**
	 * Supprime une copie d'un tuteur par son numéro
	 * @param String idcopies
	 * @return : le nbr de Copies supprimé sinon le (-) code d'erreur  
	 */
	public int deleteCopieById(String id)
	{
		int result = -1;
		//Connection à la base de données
		DBAction.DBConnexion();
		
		String req = "DELETE FROM copies WHERE idTuteur = '"+id+"' ";
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
	 * Met à jour une copie d'un tuteur par son numéro
	 * @param String idcopies,String adressecopie, float note,String etudiant_idetudiant,String matiere_idmatiere, String coefficient
	 * @return : le nbr de Copies mis à jour sinon le (-) code d'erreur  
	 */
	public static int updCopies(String idcopies,String adressecopie, float note,String etudiant_idetudiant,String matiere_idmatiere, String coefficient)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE copies SET adressecopie = '"+adressecopie+"' note = "+note+" etudiant_idetudiant = '"+etudiant_idetudiant+"' matiere_idmatiere = '"+matiere_idmatiere+"' coefficient = '"+coefficient+"' WHERE idTuteur ='"+idcopies+"' ";
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
	
}