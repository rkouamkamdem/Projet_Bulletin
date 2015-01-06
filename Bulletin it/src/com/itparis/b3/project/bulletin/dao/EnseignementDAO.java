package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.itparis.b3.project.bulletin.beans.*;
import com.itparis.b3.project.bulletin.connection.DBAction;
import com.mysql.jdbc.SQLError;

public class EnseignementDAO {

	private static Enseignement enseignTemp;
	private static ArrayList<Enseignement> listTemp;
	
	public static ArrayList<Enseignement> getAllEnseignements() throws SQLException{
		
		listTemp = new ArrayList<Enseignement>();
		enseignTemp = new Enseignement();
		
		String req = "SELECT * FROM Enseignement";

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			enseignTemp.setIdMatiere(DBAction.getRes().getString(1));
			enseignTemp.setIdProfesseur(DBAction.getRes().getString(2));
					
			listTemp.add(new Enseignement(enseignTemp.getIdMatiere(),enseignTemp.getIdProfesseur()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}

	public static Enseignement getEnseignementByIdMatiereEtIdProfesseur(String idMatiere, String idProfesseur) throws SQLException{
		
		enseignTemp = new Enseignement();
		
		String req = "SELECT * FROM Enseignement WHERE idMatiere="+idMatiere+" AND idProfesseur="+idProfesseur;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			enseignTemp.setIdMatiere(DBAction.getRes().getString(1));
			enseignTemp.setIdProfesseur(DBAction.getRes().getString(2));
					
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return enseignTemp;
	}

	public static ArrayList<Enseignement> getEnseignementsByMatiere(String idMatiere) throws SQLException{
		
		listTemp = new ArrayList<Enseignement>();
		enseignTemp = new Enseignement();
		
		String req = "SELECT * FROM Enseignement WHERE idMatiere="+idMatiere;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			enseignTemp.setIdMatiere(DBAction.getRes().getString(1));
			enseignTemp.setIdProfesseur(DBAction.getRes().getString(2));
					
			listTemp.add(new Enseignement(enseignTemp.getIdMatiere(),enseignTemp.getIdProfesseur()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	public static ArrayList<Enseignement> getEnseignementsByProfesseur(String idProfesseur) throws SQLException{
		
		listTemp = new ArrayList<Enseignement>();
		enseignTemp = new Enseignement();
		
		String req = "SELECT * FROM Enseignement WHERE idProfesseur="+idProfesseur;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			enseignTemp.setIdMatiere(DBAction.getRes().getString(1));
			enseignTemp.setIdProfesseur(DBAction.getRes().getString(2));
					
			listTemp.add(new Enseignement(enseignTemp.getIdMatiere(),enseignTemp.getIdProfesseur()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}	

	public static int addEnseignement (String idMatiere, String idProfesseur)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO evaluation (idMatiere, idProfesseur) VALUES('"+idMatiere+"', '"+idProfesseur+"')";
		try {
			result = DBAction.getStm().executeUpdate(req);
		}
		catch (SQLException ex)
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

	public static int updEnseignementByProfesseur (String idProfesseur, String idMatiere)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE enseignement SET idMatiere='"+idMatiere+" WHERE idProfesseur='"+idProfesseur;
		try {
			result = DBAction.getStm().executeUpdate(req);
		}
		catch (SQLException ex)
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
	
	public static int updEvaluationByMatiere (String idProfesseur, String idMatiere)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE enseignement SET idProfesseur='"+idProfesseur+" WHERE idMatiere='"+idMatiere;
		try {
			result = DBAction.getStm().executeUpdate(req);
		}
		catch (SQLException ex)
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
	
	public static int delEnseignement(String idProfesseur, String idMatiere)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "DELETE FROM enseignement WHERE idProfesseur = "+idProfesseur+" AND idMatiere="+idMatiere;
		try {
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
