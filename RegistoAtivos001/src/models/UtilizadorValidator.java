package models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilizadorValidator {	
	
	Utilizador u = new Utilizador();

	/**
	 * Valida��o da obrigatoriedade do Primeiro Nome
	 *
	 *  @return String
	 **/
	public Boolean checkPrimeiroNomeIsNotNull (String primeiroNome)
	{
		// Se for nulo
		if (primeiroNome == null || primeiroNome == "")
			return false;
		
		return true;
	}
	
	
	/**
	 * Valida��o da obrigatoriedade do �ltimo Nome
	 *
	 *  @return Boolean
	 **/
	public Boolean checkUltimoNomeIsNotNull (String ultimoNome)
	{
		// Se for nulo
		if (ultimoNome == null || ultimoNome == "")
			return false;
		
		return true;
	}
	
	
	/**
	 * Valida��o da obrigatoriedade do NUC
	 *
	 *  @return Boolean
	 **/
	public Boolean checkNucIsNotNull (String nuc)
	{
		// Se for nulo
		if (nuc == null || nuc == "")
			return false;
		
		return true;
	}
	
	
	/**
	* Valida��o da obrigatoriedade do E-Mail
	*
	* @return Boolean
	* 
	**/
	public Boolean checkEMailIsNotNull (String eMail)
	{
		// Se for nulo
		if (eMail == null || eMail == "")
		{
			return false;
		}
		
		return true;
	}
	
	
	/**
	* Valida��o da obrigatoriedade da password
	*
	* @return Boolean
	* 
	**/
	public Boolean checkPasswordIsNotNull (String password)
	{
		// Se for nulo ou vazio
		if (password == null || password == "")
			return false;
		
		// Caso contr�rio
		return true;
	}
	
	
	/**
	* Valida��o da obrigatoriedade da confirma��o da password
	*
	* @return Boolean
	* 
	**/
	public Boolean checkPasswordConfirmationIsNotNull (String confirmarPassword)
	{
		// Se for nulo
		if (confirmarPassword == null || confirmarPassword == "")
			return false;
		return true;
	}
	
	
	/**
	* Valida��o da carateriza��o do E-Mail
	*
	* @return Boolean
	* 
	**/
	public Boolean checkEMailIsValid (String eMail)
	{
		if (eMail == null )
			eMail = "";
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." 
				+ "[a-zA-Z0-9_+&*-]+)*@" 
				+ "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		
		if (pat.matcher(eMail).matches())
			return true;
		
		return false;
	}
	
	
	/**
	* Valida��o da password
	*
	* @return Boolean
	* 
	**/
	public Boolean checkPasswordIsValid (String password)
	{
		String emailRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";

		Pattern pat = Pattern.compile(emailRegex);
		
		// Se for valida
		if (pat.matcher(password).matches())
			return true;
		else
			return false;
		
	}
	
	
	/**
	* Valida��o da igualadade do campo entre Confirma��o e a respectiva password
	*
	* @return Boolean
	* 
	**/
	public Boolean checkPasswordConfirmationMatches (String password, String passwordConfirmation)
	{
		// Se a confirma��o for igual � password
		if (password.equals(passwordConfirmation))
			return true;
		else
		return false;
	}
	
	
	/**
	* Valida se o utilizador criado j� existe. 
	* Pesquisa na base de dados de um e-mail igual, factor �nico por conta.
	*
	* @return Boolean
	* 
	**/
	public Boolean checkUserDoesNotExist (String eMail)
	{
		// TODO
		return true;
	}
	
	/**
	* Valida��o do formul�rio com todos os campos
	*
	* @return Boolean
	* 
	**/
	public Boolean checkFormIsValid 
		(String primeiroNome, String ultimoNome, String nuc, String password, String passConfirmation, String eMail)
	{
		if (
				checkEMailIsValid(eMail) 
				&& checkEMailIsNotNull(eMail) 
				&& checkNucIsNotNull(nuc)
				&& checkPasswordIsValid(password)
				&& checkPasswordConfirmationIsNotNull(password)
				&& checkPasswordConfirmationMatches(password, passConfirmation)
				&& checkPasswordIsNotNull(password)
				&& checkPrimeiroNomeIsNotNull(primeiroNome)
				&& checkUltimoNomeIsNotNull(ultimoNome)
				&& checkUserDoesNotExist(eMail)
			)
			return true;
		else
		return false;
	}
	
	/**
	* Valida��o do formul�rio com o Primeiro, �ltimo nome, nuc e e-mail
	*
	* @return Boolean
	* 
	**/
	public Boolean checkFormIsValid 
		(String primeiroNome, String ultimoNome, String nuc,  String eMail)
	{
		if (
				checkEMailIsValid(eMail) 
				&& checkEMailIsNotNull(eMail) 
				&& checkNucIsNotNull(nuc)
				&& checkPrimeiroNomeIsNotNull(primeiroNome)
				&& checkUltimoNomeIsNotNull(ultimoNome)
				&& checkUserDoesNotExist(eMail)
			)
			return true;
		else
		return false;
	}
	
	
	/**
	* Valida��o do formul�rio com o Primeiro, �ltimo nome, nuc e e-mail
	*
	* @return Boolean
	* 
	**/
	public Boolean checkFormIsValid 
		(String passwordAntiga, String password, String confirmarPassword)
	{
		if 
		(
				checkPasswordIsValid(password)
				&& checkPasswordIsValid(passwordAntiga)
				&& checkPasswordConfirmationIsNotNull(password)
				&& checkPasswordConfirmationMatches(password, confirmarPassword)
				&& checkPasswordIsNotNull(password)
				&& checkPasswordIsNotNull(passwordAntiga)
		)
			return true;
		else
		return false;
	}
	
}
