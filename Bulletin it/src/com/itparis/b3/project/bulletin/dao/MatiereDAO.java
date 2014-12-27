package com.itparis.b3.project.bulletin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.itparis.b3.project.bulletin.connection.DBAction;
import com.itparis.b3.project.bulletin.beans.Matiere;
import com.mysql.jdbc.SQLError;

/**
 * 
 * @author Kouam romeo
 * @version v0.1
 * Le 24/12/2014
 */

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
		 * Lister une mati�re en particulier d'apr�s son identifiant pass� en param�tre de la fonction.
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
			
			// Fermeture de la connexion
			DBAction.DBClose();
			return matiereTemp;
		}
		
		/**
		 * Lister des mat�res par module.
		 * @param Aucun
		 * @return : retourne l'objet matiereTemp 
		 * @throws SQLException
		 */
		public static ArrayList<Matiere> getAllMatiereByModule() throws SQLException
		{
			ArrayList<Matiere> listMatiere = new ArrayList<Matiere>();
			
			String req = "SELECT matiere.idmatiere, matiere.nom, matiere.module_idmodule, matiere.coefficient WHERE matiere.module_idmodule IN (SELECT idmodule FROM Module) GROUP BY matiere.module_idmodule ";
			
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
		 * Ajout d'une mati�re.
		 * @param String idmatiere,String nom,String coefficient
		 * @return : retourne l'objet matiereTemp 
		 * @throws SQLException
		 */
		public static int addMatiere(String idmatiere,String nom,String coefficient) throws SQLException
		{
			int result = -1;
			DBAction.DBConnexion();

			String req = "INSERT INTO matiere (idmatiere, nom, module_idmodule, coefficient) VALUES('idmatiere', 'nom', NULL, 'coefficient') ";
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
		
		/**
		 * Mise � jour d'une mati�re.
		 * @param String idmatiere,String nom,String coefficient,String module_idmodule
		 * @return : retourne un entier indiquant le nbre de mati�re modifi�. 
		 * @throws SQLException
		 */
		public static int updMatiere(String idmatiere,String nom,String coefficient,String module_idmodule) throws SQLException
		{
			
			int result = -1;
			DBAction.DBConnexion();

			String req = "UPDATE matiere SET nom='"+nom+"', module_idmodule = IF('"+module_idmodule+"' IS NULL ,null,'"+module_idmodule+"'), coefficient ='"+coefficient+"' WHERE idmatiere = '"+idmatiere+"'  ";
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
		
		/**
		 * Suppression d'une mati�re.
		 * @param String idmatiere
		 * @return : retourne un entier indiquant le nbre de mati�re supprim�. 
		 * @throws SQLException
		 */
		public static int delMatiere(String idmatiere) throws SQLException
		{	
			int result = -1;
			DBAction.DBConnexion();
			
			String req = "DELETE FROM matiere WHERE idmatiere = '"+idmatiere+"' ";
			try
			{
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
		
}
