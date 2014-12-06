package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;


import com.itparis.b3.project.bulletin.connection.*;
import com.itparis.b3.project.bulletin.beans.Matiere;

public class MatiereDAO {
	
	
		public static ArrayList<Matiere> getAllMatiere() throws SQLException 
		{
			
			ArrayList<Matiere> listMatiere = new ArrayList<Matiere>();
			
			String req = "SELECT num, no, nom, age, adresse FROM eleve ";
			// Connexion
			DBAction.DBConnexion();
			// exécution de la requête et init
			DBAction.setRes(DBAction.getStm().executeQuery(req));
			
			while( DBAction.getRes().next() )
			{	
				//int i = 0;
				//Instanciation de mon objet Matiere
				Matiere matiereTemp = new Matiere();
				
				// Creation de l'objet eleveTemp à travers le ResultSet BD
				matiereTemp.setNum(DBAction.getRes().getString(1));
				matiereTemp.setNo(DBAction.getRes().getInt(2));
				matiereTemp.setNom(DBAction.getRes().getString(3));
				matiereTemp.setAge(DBAction.getRes().getInt(4));
				matiereTemp.setAdresse(DBAction.getRes().getString(5));
				listMatiere.add(matiereTemp);
				//i = i + 1;
			}
			// Fermeture de la connexion
			DBAction.DBClose();
			return listMatiere;
		}
	
	
}
