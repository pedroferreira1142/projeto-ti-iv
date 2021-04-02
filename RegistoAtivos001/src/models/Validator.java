package models;

import java.util.List;

public class Validator 
{
	/**
	 * Validação da obrigatoriedade de um campo
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
	* Validação dos campos do Tipo String
	*
	* @param String campos do formulário
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
