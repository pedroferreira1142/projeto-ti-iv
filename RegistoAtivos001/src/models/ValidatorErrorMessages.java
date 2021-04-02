package models;

public class ValidatorErrorMessages 
{
	private String _errorCannotBeNull = "Campo obrigatório";

	public String get_errorNotNull() {
		return _errorCannotBeNull;
	}

	public void set_errorNotNull(String _errorNotNull) {
		this._errorCannotBeNull = _errorNotNull;
	}
}
