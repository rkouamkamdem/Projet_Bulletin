package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.itparis.b3.project.bulletin.beans.*;
import com.itparis.b3.project.bulletin.connection.DBAction;
import com.mysql.jdbc.SQLError;

public class EvaluationDAO {

	private static Evaluation evalTemp;
	private static ArrayList<Evaluation> listTemp;
	
	public static ArrayList<Evaluation> getAllEvaluations() throws SQLException{
		
		listTemp = new ArrayList<Evaluation>();
		evalTemp = new Evaluation();
		
		String req = "SELECT * FROM Evaluation";

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			evalTemp.setIdEtudiant(DBAction.getRes().getString(1));
			evalTemp.setIdModule(DBAction.getRes().getString(2));
			
			listTemp.add(new Evaluation(evalTemp.getIdEtudiant(),evalTemp.getIdModule()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}

	public static Evaluation getEvaluationByIdEtudiantEtIdModule(String idEtudiant, String idModule) throws SQLException{
		
		evalTemp = new Evaluation();
		
		String req = "SELECT * FROM Evaluation WHERE idEtudiant="+idEtudiant+" AND idModule="+idModule;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			evalTemp.setIdEtudiant(DBAction.getRes().getString(1));
			evalTemp.setIdModule(DBAction.getRes().getString(2));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return evalTemp;
	}

	public static ArrayList<Evaluation> getEvaluationsByIdEtudiant(String idEtudiant) throws SQLException{
		
		listTemp = new ArrayList<Evaluation>();
		evalTemp = new Evaluation();
		
		String req = "SELECT * FROM Evaluation WHERE idEtudiant="+idEtudiant;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			evalTemp.setIdEtudiant(DBAction.getRes().getString(1));
			evalTemp.setIdModule(DBAction.getRes().getString(2));
			
			listTemp.add(new Evaluation(evalTemp.getIdEtudiant(),evalTemp.getIdModule()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}

	public static ArrayList<Evaluation> getEvaluationsByIdModule(String idModule) throws SQLException{
		
		listTemp = new ArrayList<Evaluation>();
		evalTemp = new Evaluation();
		
		String req = "SELECT * FROM Evaluation WHERE idEtudiant="+idModule;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			evalTemp.setIdEtudiant(DBAction.getRes().getString(1));
			evalTemp.setIdModule(DBAction.getRes().getString(2));
			
			listTemp.add(new Evaluation(evalTemp.getIdEtudiant(),evalTemp.getIdModule()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static int addEvaluation (String idEtudiant, String idModule)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO evaluation (idEtudiant, idModule) VALUES('"+idEtudiant+"', '"+idModule+"')";
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

	public static int updEvaluationByEtudiant (String idEtudiant, String idModule)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE evaluation SET idModule='"+idModule+" WHERE idEtudiant='"+idEtudiant;
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
	
	public static int updEvaluationByModule (String idEtudiant, String idModule)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE evaluation SET idEtudiant='"+idEtudiant+" WHERE idModule='"+idModule;
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
	
	public static int delEvaluation(String idEtudiant, String idModule)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "DELETE FROM evaluation WHERE idEtudiant = "+idEtudiant+" AND idModule="+idModule;
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
