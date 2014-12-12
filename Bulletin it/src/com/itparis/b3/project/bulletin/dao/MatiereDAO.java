package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;


import com.itparis.b3.project.bulletin.connection.*;
import com.itparis.b3.project.bulletin.beans.Matiere;

public class MatiereDAO {
	
	/**
	 * Lister l'ensemble des mat�res existantes en base.
	 * @param Aucun
	 * @return : retourne une liste des mati�res 
	 * @throws SQLException
	 */
		public static ArrayList<Matiere> getAllMatiere() throws SQLException 
		{
			
			ArrayList<Matiere> listMatiere = new ArrayList<Matiere>();
			
			String req = "SELECT idMatiere, nom, Module_idModule, Coefficient FROM matiere ";
			
			// Connexion
			DBAction.DBConnexion();
			
			// ex�cution de la requ�te et init
			DBAction.setRes(DBAction.getStm().executeQuery(req));
			
			//Recup�ration des mati�res renvoy�es par la base de donn�es.
			while( DBAction.getRes().next() )
			{	
				//Instanciation de mon objet Matiere
				Matiere matiereTemp = new Matiere();
				
				// Creation de l'objet eleveTemp � travers le ResultSet BD
				matiereTemp.setId(DBAction.getRes().getString(1));
				matiereTemp.setNom(DBAction.getRes().getString(2));
				matiereTemp.setIdModule(DBAction.getRes().getString(3));
				matiereTemp.setCoefficient(DBAction.getRes().getString(4));
				listMatiere.add(matiereTemp);
			}
			// Fermeture de la connexion
			DBAction.DBClose();
			return listMatiere;
		}
		
		
		/**
		 * Lister une mat�re en particulier d'apr�s son identifiant pass� en param�tre de la fonction.
		 * @param String id
		 * @return : retourne l'objet matiereTemp 
		 * @throws SQLException
		 */
		public static Matiere getMatiereById(String id) throws SQLException
		{
			//Instanciation de mon objet Matiere
			Matiere matiereTemp = new Matiere();
			
			String req = "SELECT idMatiere, nom, Module_idModule, Coefficient FROM matiere WHERE id="+id+" ";
			
			// Connexion
			DBAction.DBConnexion();
			
			// ex�cution de la requ�te et init
			DBAction.setRes(DBAction.getStm().executeQuery(req));
			
			while( DBAction.getRes().next() )
			{
				// Creation de l'objet matiereTemp � travers le ResultSet BD
				matiereTemp.setId(DBAction.getRes().getString(1));
				matiereTemp.setNom(DBAction.getRes().getString(2));
				matiereTemp.setIdModule(DBAction.getRes().getString(3));
				matiereTemp.setCoefficient(DBAction.getRes().getString(4));
			}
			return matiereTemp;
		}
		
}
