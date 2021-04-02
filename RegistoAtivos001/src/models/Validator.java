package models;

import java.util.List;

public class Validator 
{
	/**
	 * Valida��o da obrigatoriedade de um campo
	 *
	 * @param String campo
	 * @return Boolean
	 **/
	public Boolean checkIfIsNotNull (String campo)
	{
		// Se for nulo
		if (campo == null || campo == "")
			return false;
		
		return true;
	}
	
	
	/**
	* Valida��o dos campos do Tipo String
	*
	* @param String campos do formul�rio
	* @return Boolean
	* 
	**/
	public Boolean checkFieldListAreNull 
		(List<String> campos)
	{
		// Se encontrar um campo nulo
		for (String campo : campos) {
			// Se o campo for nulo
            if (!checkIfIsNotNull(campo))
            	return true;
        }
		return false;
	}
}
