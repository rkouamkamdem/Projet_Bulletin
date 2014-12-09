package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;


import com.itparis.b3.project.bulletin.connection.*;
import com.itparis.b3.project.bulletin.beans.*;

public class TuteurDAO {
	
public static Tuteur getTuteurById(String id) throws SQLException{
		
		Tuteur tuteurTemp = new Tuteur();
		
		String req = "SELECT * FROM Tuteur WHERE id="+id;

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		DBAction.getRes().next();
		
		tuteurTemp.setId(DBAction.getRes().getString(1));
		tuteurTemp.setNom(DBAction.getRes().getString(2));
		tuteurTemp.setPrenom(DBAction.getRes().getString(3));
		tuteurTemp.setEmail(DBAction.getRes().getString(4));
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return tuteurTemp;
	}
	
	public static ArrayList<Tuteur> getAllTuteur() throws SQLException{
		
		ArrayList<Tuteur> listTemp = new ArrayList <Tuteur>();
		Tuteur tuteurTemp = new Tuteur();
		
		String req = "SELECT * FROM Tuteur";

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			tuteurTemp.setId(DBAction.getRes().getString(1));
			tuteurTemp.setNom(DBAction.getRes().getString(2));
			tuteurTemp.setPrenom(DBAction.getRes().getString(3));
			tuteurTemp.setEmail(DBAction.getRes().getString(4));
			
			listTemp.add(new Tuteur(tuteurTemp.getId(),tuteurTemp.getNom(),tuteurTemp.getPrenom(), tuteurTemp.getEmail()));
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		return listTemp;
	}
}
