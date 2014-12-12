package com.itparis.b3.project.bulletin.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itparis.b3.project.bulletin.beans.*;
import com.mysql.jdbc.SQLError;

public class CopieDAO {

	/**
	 * 
	 */
	private ArrayList<Copie> lstCopies;
	private Copie copie;
	
	public ArrayList<Copie> getAllCopies(){
		lstCopies = new ArrayList<Copie>();
		
		//Connexion
		//Requete
		//transformation du résultat de la liste du resultSet vers une liste de copies (beans)
		//gestion de l'exception
		
		return lstCopies;
	}

	public Copie getCopieById(String id){
		
		//Connexion
		//Requete
		//transformation du résultat du resultSet vers une copie (beans)
		//gestion de l'exception
		
		return copie;
	}

	/**
	 * 
	 * @param id
	 * @return 1 si le delete est Ok - 0 si l'id n'exite pas - -1 si une erreur de connexion - -2 si timeout de la réponse
	 */
	public int deleteCopieById(String id){
		int code =0;
		//SQLException e;

		//Connexion
		//Requete
		//transformation du résultat du resultSet vers une copie (beans) : code = 0 ou code = 1

		try{
			code = 1;
			
		}
		catch(Exception e){
			int codeE = ((SQLException) e).getErrorCode();
			if(SQLError.SQL_STATE_CONNECTION_REJECTED.equals(codeE))
				code = -1;
			else if (SQLError.SQL_STATE_CONNECTION_FAIL_DURING_TX.equals(codeE))
			code = -2;

		}

		//gestion de l'exception selon l'erreur : code = -1 ou code = -2
		
		
		return code;
	}




}
