package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.itparis.b3.project.bulletin.beans.*;
import com.itparis.b3.project.bulletin.connection.DBAction;
import com.mysql.jdbc.SQLError;

public class SessionDAO {

	private static Session sessionTemp;
	private static ArrayList<Session> listTemp;
	
	public static ArrayList<Session> getAllSessions() throws SQLException{
		
		listTemp = new ArrayList<Session>();
		sessionTemp = new Session();
		
		String req = "SELECT * FROM Session";

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			sessionTemp.setId(DBAction.getRes().getString(1));
			sessionTemp.setNom(DBAction.getRes().getString(2));
			sessionTemp.setPrenom(DBAction.getRes().getString(3));
			sessionTemp.setLogin(DBAction.getRes().getString(4));
			sessionTemp.setMdp(DBAction.getRes().getString(5));
			sessionTemp.setCategorie(DBAction.getRes().getString(6));
			sessionTemp.setEmail(DBAction.getRes().getString(7));
					
			listTemp.add(new Session(sessionTemp.getId(),sessionTemp.getNom(),sessionTemp.getPrenom(),sessionTemp.getLogin(),sessionTemp.getMdp(),sessionTemp.getCategorie(),sessionTemp.getEmail()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}

	public static Session getSessionById(String id) throws SQLException{
		
		sessionTemp = new Session();
		
		String req = "SELECT * FROM Session WHERE id="+id;
	
		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			sessionTemp.setId(DBAction.getRes().getString(1));
			sessionTemp.setNom(DBAction.getRes().getString(2));
			sessionTemp.setPrenom(DBAction.getRes().getString(3));
			sessionTemp.setLogin(DBAction.getRes().getString(4));
			sessionTemp.setMdp(DBAction.getRes().getString(5));
			sessionTemp.setCategorie(DBAction.getRes().getString(6));
			sessionTemp.setEmail(DBAction.getRes().getString(7));			
		}
		//Fermeture de la connexion
		DBAction.DBClose();
	
		//Retour du résultat
		
		return sessionTemp;
	}

	public static ArrayList<Session> getSessionsByNomEtPrenom(String nom, String prenom) throws SQLException{
		
		listTemp = new ArrayList<Session>();
		sessionTemp = new Session();
		
		String req = "SELECT * FROM Session WHERE nom="+nom+" AND prenom="+prenom;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			sessionTemp.setId(DBAction.getRes().getString(1));
			sessionTemp.setNom(DBAction.getRes().getString(2));
			sessionTemp.setPrenom(DBAction.getRes().getString(3));
			sessionTemp.setLogin(DBAction.getRes().getString(4));
			sessionTemp.setMdp(DBAction.getRes().getString(5));
			sessionTemp.setCategorie(DBAction.getRes().getString(6));
			sessionTemp.setEmail(DBAction.getRes().getString(7));
					
			listTemp.add(new Session(sessionTemp.getId(),sessionTemp.getNom(),sessionTemp.getPrenom(),sessionTemp.getLogin(),sessionTemp.getMdp(),sessionTemp.getCategorie(),sessionTemp.getEmail()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}

	public static ArrayList<Session> getSessionsByLoginEtMdp(String login, String mdp) throws SQLException{
		
		listTemp = new ArrayList<Session>();
		sessionTemp = new Session();
		
		String req = "SELECT * FROM Session WHERE login="+login+" AND mdp="+mdp;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			sessionTemp.setId(DBAction.getRes().getString(1));
			sessionTemp.setNom(DBAction.getRes().getString(2));
			sessionTemp.setPrenom(DBAction.getRes().getString(3));
			sessionTemp.setLogin(DBAction.getRes().getString(4));
			sessionTemp.setMdp(DBAction.getRes().getString(5));
			sessionTemp.setCategorie(DBAction.getRes().getString(6));
			sessionTemp.setEmail(DBAction.getRes().getString(7));
					
			listTemp.add(new Session(sessionTemp.getId(),sessionTemp.getNom(),sessionTemp.getPrenom(),sessionTemp.getLogin(),sessionTemp.getMdp(),sessionTemp.getCategorie(),sessionTemp.getEmail()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static ArrayList<Session> getSessionsCategorie(String categorie) throws SQLException{
		
		listTemp = new ArrayList<Session>();
		sessionTemp = new Session();
		
		String req = "SELECT * FROM Session WHERE categorie="+categorie;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			sessionTemp.setId(DBAction.getRes().getString(1));
			sessionTemp.setNom(DBAction.getRes().getString(2));
			sessionTemp.setPrenom(DBAction.getRes().getString(3));
			sessionTemp.setLogin(DBAction.getRes().getString(4));
			sessionTemp.setMdp(DBAction.getRes().getString(5));
			sessionTemp.setCategorie(DBAction.getRes().getString(6));
			sessionTemp.setEmail(DBAction.getRes().getString(7));
					
			listTemp.add(new Session(sessionTemp.getId(),sessionTemp.getNom(),sessionTemp.getPrenom(),sessionTemp.getLogin(),sessionTemp.getMdp(),sessionTemp.getCategorie(),sessionTemp.getEmail()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static ArrayList<Session> getSessionsByEmail(String eMail) throws SQLException{
		
		listTemp = new ArrayList<Session>();
		sessionTemp = new Session();
		
		String req = "SELECT * FROM Session WHERE eMail="+eMail;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			sessionTemp.setId(DBAction.getRes().getString(1));
			sessionTemp.setNom(DBAction.getRes().getString(2));
			sessionTemp.setPrenom(DBAction.getRes().getString(3));
			sessionTemp.setLogin(DBAction.getRes().getString(4));
			sessionTemp.setMdp(DBAction.getRes().getString(5));
			sessionTemp.setCategorie(DBAction.getRes().getString(6));
			sessionTemp.setEmail(DBAction.getRes().getString(7));
					
			listTemp.add(new Session(sessionTemp.getId(),sessionTemp.getNom(),sessionTemp.getPrenom(),sessionTemp.getLogin(),sessionTemp.getMdp(),sessionTemp.getCategorie(),sessionTemp.getEmail()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
	
	public static int addSession (String id,String nom, String prenom, String login, String mdp, String categorie, String eMail)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO session (id, nom, prenom, login, mdp, categorie, eMail) VALUES('"+id+"', '"+nom+"', '"+prenom+"', '"+login+"', '"+mdp+"', '"+categorie+"', '"+eMail+"')";
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

	public static int updSession (String id,String nom, String prenom, String login, String mdp, String categorie, String eMail)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE session SET nom='"+nom+"', prenom='"+prenom+"', login='"+login+"', mdp='"+mdp+"', categorie='"+categorie+"', eMail='"+eMail+"' WHERE id="+id;
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
	
	public static int delSession(String id)
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "DELETE FROM session WHERE id = "+id;
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

