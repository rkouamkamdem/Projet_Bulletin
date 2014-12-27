package com.itparis.b3.project.bulletin.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import com.itparis.b3.project.bulletin.connection.DBAction;
import com.itparis.b3.project.bulletin.beans.Module;
import com.mysql.jdbc.SQLError;

/**
 * @author Kouam romeo
 * @version v0.1
 * Le 27/12/2014
 */
public class ModuleDAO
{
	/**
	 * Lister l'ensemble des modules existant en base.
	 * @param Aucun
	 * @return : retourne une liste de Modules
	 * @throws SQLException
	 */
		public static ArrayList<Module> getAllModule() throws SQLException 
		{	
			ArrayList<Module> listModule = new ArrayList<Module>();
			String req = "SELECT idmodule, nom, coefficient FROM module ";
			
			// Connexion
			DBAction.DBConnexion();
			
			// exécution de la requête et init
			DBAction.setRes(DBAction.getStm().executeQuery(req));
			
			//Recupération des matières renvoyées par la base de données.
			while( DBAction.getRes().next() )
			{	
				//Instanciation de mon objet moduleTemp
				Module moduleTemp = new Module();
				
				// Creation de l'objet moduleTemp à travers le ResultSet BD
				moduleTemp.setId(DBAction.getRes().getString(1));
				moduleTemp.setNom(DBAction.getRes().getString(2));
				moduleTemp.setCoefficient(DBAction.getRes().getString(3));
				listModule.add(moduleTemp);
			}
			// Fermeture de la connexion
			DBAction.DBClose();
			return listModule;
		}
		
		/**
		 * Lister un Module en particulier d'après son identifiant passé en paramètre de la fonction.
		 * @param String id
		 * @return : retourne l'objet moduleTemp 
		 * @throws SQLException
		 */
		public static Module getModuleById(String idModule) throws SQLException
		{
			//Instanciation de mon objet Matiere
			Module moduleTemp = new Module();
			
			String req = "SELECT idMatiere, nom, Module_idModule, Coefficient FROM module WHERE idmodule="+idModule+" ";
			
			// Connexion
			DBAction.DBConnexion();
			
			// exécution de la requête et init
			DBAction.setRes(DBAction.getStm().executeQuery(req));
			
			while( DBAction.getRes().next() )
			{
				// Creation de l'objet moduleTemp à travers le ResultSet BD
				moduleTemp.setId(DBAction.getRes().getString(1));
				moduleTemp.setNom(DBAction.getRes().getString(2));
				moduleTemp.setCoefficient(DBAction.getRes().getString(3));
			}
			
			// Fermeture de la connexion
			DBAction.DBClose();
			return moduleTemp;
		}
		
		/**
		 * Lister les Modules par matière.
		 * @param Aucun
		 * @return : retourne la liste listModule 
		 * @throws SQLException
		 */
		public static ArrayList<Module> getModuleByMatiere () throws SQLException
		{
			ArrayList<Module> listModule = new ArrayList<Module>();
			String req = "SELECT module.idmodule, module.nom, module.coefficient, matiere.idmatiere, matiere.nom FROM module INNER JOIN matiere ON module.idmodule = matiere.module_idmodule GROUP BY module.idmodule ORDER BY module.nom ASC  ";
			
			// Connexion
			DBAction.DBConnexion();
			
			// exécution de la requête et init
			DBAction.setRes(DBAction.getStm().executeQuery(req));
			
			//Recupération des matières renvoyées par la base de données.
			while( DBAction.getRes().next() )
			{	
				//Instanciation de mon objet moduleTemp
				Module moduleTemp = new Module();
				
				// Creation de l'objet moduleTemp à travers le ResultSet BD
				moduleTemp.setId(DBAction.getRes().getString(1));
				moduleTemp.setNom(DBAction.getRes().getString(2));
				moduleTemp.setCoefficient(DBAction.getRes().getString(3));
				listModule.add(moduleTemp);
			}
			// Fermeture de la connexion
			DBAction.DBClose();
			return listModule;
		}
		
		/**
		 * Ajout un Module.
		 * @param String idmodule,String nom, String coefficient
		 * @return : retourne result : Le nombre de module rajouté sinon un entier (-)X. 
		 * @throws SQLException
		 */
		public static int addModule (String idmodule,String nom, String coefficient)
		{
			int result = -1;
			DBAction.DBConnexion();

			String req = "INSERT INTO module (idmodule, nom,coefficient) VALUES('idmodule', 'nom','coefficient')";
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
		 * Mise à jour un Module.
		 * @param String idmodule,String nom, String coefficient
		 * @return : retourne un entier indiquant le nbre de Module modifié. 
		 * @throws SQLException
		 */
		public static int updModule (String idmodule,String nom, String coefficient)
		{
			int result = -1;
			DBAction.DBConnexion();

			String req = "UPDATE module SET nom='nom', coefficient='coefficient WHERE idmodule = 'idmodule' ";
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
		 * Suppression d'un Module.
		 * @param String idmodule
		 * @return : retourne un entier indiquant le nbre de Module supprimé. 
		 * @throws SQLException
		 */
		public static int delModule(String idmodule)
		{
			int result = -1;
			DBAction.DBConnexion();

			String req = "DELETE FROM module WHERE idmodule = 'idmodule' ";
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
