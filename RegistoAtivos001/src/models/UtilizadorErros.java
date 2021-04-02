package models;

public class UtilizadorErros {
	private String _errorPrimeiroNomeNull = "O primeiro nome n�o pode ser nulo";
	private String _errorUltimoNomeNull = "O �ltimo nome n�o pode ser nulo.";
	private String _errorEMailNull = "O e-mail n�o pode ser nulo";
	private String _errorNucNull = "O NUC n�o pode ser nulo.";
	private String _errorPasswordNull = "A password n�o pode ser nula.";
	private String _errorPasswordConfirmationNull = "A confirma��o de password n�o pode ser nula.";
	private String _errorEMailNotQualified = "O E-mail n�o � v�lido.";
	private String _errorPasswordNotQualified = "A password rege-se por:\n" + 
			"Pelo menos uma letra mai�scula\n" + 
			"Um Caract�r especial\n" + 
			"E um n�mero\n";
	private String _errorPasswordDoesNotMatch = "As passwords n�o coincidem";
	private String _errorUserAlreadyExists = "Esse e-mail j� se encontra registado";

	public String get_errorUserAlreadyExists() {
		return _errorUserAlreadyExists;
	}


	public void set_errorUserAlreadyExists(String _errorUserAlreadyExists) {
		this._errorUserAlreadyExists = _errorUserAlreadyExists;
	}


	public String get_errorPasswordDoesNotMatch() {
		return _errorPasswordDoesNotMatch;
	}


	public void set_errorPasswordDoesNotMatch(String _errorPasswordDoesNotMatch) {
		this._errorPasswordDoesNotMatch = _errorPasswordDoesNotMatch;
	}


	public String get_errorPasswordNotQualified() {
		return _errorPasswordNotQualified;
	}


	public void set_errorPasswordNotQualified(String _errorPasswordNotQualified) {
		this._errorPasswordNotQualified = _errorPasswordNotQualified;
	}


	public String get_errorEMailNotQualified() {
		return _errorEMailNotQualified;
	}


	public void set_errorEMailNotQualified(String _errorEMailNotQualified) {
		this._errorEMailNotQualified = _errorEMailNotQualified;
	}


	public String get_errorPasswordConfirmationNull() {
		return _errorPasswordConfirmationNull;
	}


	public void set_errorPasswordConfirmationNull(String _errorPasswordConfirmationNull) {
		this._errorPasswordConfirmationNull = _errorPasswordConfirmationNull;
	}


	public String get_errorPasswordNull() {
		return _errorPasswordNull;
	}


	public void set_errorPasswordNull(String _errorPasswordNull) {
		this._errorPasswordNull = _errorPasswordNull;
	}


	public String get_errorNucNull() {
		return _errorNucNull;
	}


	public void set_errorNucNull(String _errorNucNull) {
		this._errorNucNull = _errorNucNull;
	}


	public String get_errorEMailNull() {
		return _errorEMailNull;
	}


	public void set_errorEMailNull(String _errorEMailNull) {
		this._errorEMailNull = _errorEMailNull;
	}


	public String get_errorUltimoNomeNull() {
		return _errorUltimoNomeNull;
	}


	public void set_errorUltimoNomeNull(String _errorUltimoNomeNull) {
		this._errorUltimoNomeNull = _errorUltimoNomeNull;
	}


	public String get_errorPrimeiroNomeNull() {
		return _errorPrimeiroNomeNull;
	}


	public void set_errorPrimeiroNomeNull(String _errorPrimeiroNomeNull) {
		this._errorPrimeiroNomeNull = _errorPrimeiroNomeNull;
	}

}
