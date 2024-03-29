package models;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UtilizadorHelper {

	/**
	 * Cria��o de um utilizador
	 * 
	 * @param Utilizador
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws SQLException
	 */
	public void criarUtilizador(Utilizador utilizador) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		try {
			// Encriptador
			PasswordEncryption pE = new PasswordEncryption();

			// Data atual
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			// Salt
			byte[] salt = pE.gerarSalt();
			String passwordByteArrayToString = new String(utilizador.getPassword());
			

			PreparedStatement stmntCreate = con.prepareCall("{call SP_UTILIZADOR_CRIAR(?,?,?,?,?,?,?,?)}");

			// Atribui��o dos valores ao statement
			stmntCreate.setString(1, UUID.randomUUID().toString());
			stmntCreate.setString(2, utilizador.geteMail());
			stmntCreate.setBytes(3, pE.getPasswordEncriptada(passwordByteArrayToString, salt));
			stmntCreate.setBytes(4, salt);
			stmntCreate.setDate(5, sqlDate);
			stmntCreate.setString(6, utilizador.getPrimeiroNome());
			stmntCreate.setString(7, utilizador.getUltimoNome());
			stmntCreate.setString(8, utilizador.getNuc());

			// Execu��o da query
			stmntCreate.executeQuery();

			// Desconex�o
			conexaoDB.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Extrair um utilizador
	 * 
	 * @param String eMail
	 * @throws SQLException
	 * @return Utilizador
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public Utilizador getUtilizadorByEMail(String eMail) throws IllegalArgumentException, IllegalAccessException {
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Instaciamento Utilizador
		Utilizador utilizador = new Utilizador();

		// Tabela de dados
		ResultSet rSetUtilizador = null;

		try {
			// Stored Procedure
			PreparedStatement stmntGet = con.prepareCall("{call SP_UTILIZADOR_GET_BY_EMAIL(?)}");

			// Atribui��o dos valores ao statement
			stmntGet.setString(1, eMail);

			// Execu��o da query
			rSetUtilizador = stmntGet.executeQuery();

			// Mover o cursos para o primeiro index
			rSetUtilizador.next();

			// Convers�o de um resultSet para um (objecto)estado:
			DBConverter.loadResultSetIntoObject(rSetUtilizador, utilizador);

			// Desconex�o
			conexaoDB.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return utilizador;
	}

	/**
	 * Editar um utilizador
	 * 
	 * @param Utilizador
	 * @throws SQLException
	 */
	public void editarUtilizador(Utilizador utilizador) {
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		try {
			// Stored Procedure
			PreparedStatement stmntGet = con.prepareCall("{call SP_UTILIZADOR_EDITAR_INFO(?,?,?,?)}");

			// Atribui��o dos valores ao statement
			stmntGet.setString(1, utilizador.getPrimeiroNome());
			stmntGet.setString(2, utilizador.getUltimoNome());
			stmntGet.setString(3, utilizador.getNuc());
			stmntGet.setString(4, utilizador.geteMail());

			// Execu��o da query
			stmntGet.executeQuery();

			// Desconex�o
			conexaoDB.disconnect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Editar permiss�es de um utilizador
	 * 
	 * @param Utilizador
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SQLException
	 */
	public void editarTipoUtilizador(String eMail, int tipo) throws IllegalArgumentException, IllegalAccessException 
	{
		//Instaciamentos:
		Utilizador u = new Utilizador();
		
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Extrair o utilizador por eMail
		u = this.getUtilizadorByEMail(eMail);

		try {
			// Stored Procedure
			PreparedStatement stmntGet = con.prepareCall("{call SP_UTILIZADOR_EDITAR_TIPO(?,?)}");

			// Atribui��o dos valores ao statement
			stmntGet.setString(1, eMail);
			stmntGet.setInt(2, tipo);

			// Execu��o da query
			stmntGet.executeQuery();

			// Desconex�o
			conexaoDB.disconnect();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Apagar um utilizador
	 * 
	 * @param Utilizador
	 * @throws SQLException
	 */
	public void apagarUtilizador(String idUtilizador) {
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		try {
			// Stored Procedure
			PreparedStatement stmntGet = con.prepareCall("{call STORED_PROCEDURE_APAGAR_UTILIZADOR(?)}");

			// Atribui��o dos valores ao statement
			stmntGet.setString(1, idUtilizador);

			// Execu��o da query
			stmntGet.executeQuery();

			// Desconex�o
			conexaoDB.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verifica os dados de tentativa de login com os registo na base de dados
	 * 
	 * @param email
	 * @param password
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * 
	 * @return Utilizador
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 */
	public Utilizador checkLogin(String eMail, String password)
			throws SQLException, ClassNotFoundException, 
			IllegalArgumentException, IllegalAccessException,
			NoSuchAlgorithmException, InvalidKeySpecException 
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Encriptador
		PasswordEncryption pE = new PasswordEncryption();

		// Utilizador
		Utilizador utilizador = new Utilizador();
		UtilizadorHelper uH = new UtilizadorHelper();
		
		// Pesquisa o utilizador por eMail:
		utilizador = uH.getUtilizadorByEMail(eMail);
		
		// Autentica��o com password
		if (pE.autenticacao(password, utilizador.getPassword(), utilizador.getPasswordSalt()))
			return utilizador;

		// Desconex�o
		conexaoDB.disconnect();

		return new Utilizador();
	}
	
	
	/**
	 * Atualiza��o da password
	 * 
	 * @param password
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * 
	 * @return Utilizador
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 */
	public void changePassword(String password, String uid) throws NoSuchAlgorithmException, SQLException, InvalidKeySpecException
			 
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		PreparedStatement stmntCreate = con.prepareCall("{call SP_UTILIZADOR_EDITAR_PASSWORD(?,?,?)}");
		
		// Encriptador
		PasswordEncryption pE = new PasswordEncryption();
		
		// Salt
		byte[] salt = pE.gerarSalt();
		String passwordByteArrayToString = new String(password);
		
		// Pesquisa o utilizador por eMail:
		stmntCreate.setBytes(1, pE.getPasswordEncriptada(password, salt));
		stmntCreate.setBytes(2, salt);
		stmntCreate.setString(3, uid);
		
		// Execu��o da query
		stmntCreate.executeQuery();

		// Desconex�o
		conexaoDB.disconnect();

	}
	
	/**
	*  Listar utilizadores
	*  
	*  @throws SQLException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException
	 * 
	 * @return listagem utilizadores 
	*/
	public List<Utilizador> listarUtilizador() throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Lista de tipos de movimento:
		List<Utilizador> listaUtilizador = new ArrayList<Utilizador>();
		
		// Tabela de dados
		ResultSet rSetUtilizador = null;
		
		try 
		{
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_UTILIZADOR_LISTAR()}");
			
			// Execu��o da query
			rSetUtilizador = stmntList.executeQuery();
			
			// Cria��o da lista de objetos:
			while (rSetUtilizador.next()) {
				Utilizador u = new Utilizador();                
                // Convers�o de um registo rSet para um objecto:
                DBConverter.loadResultSetIntoObject(rSetUtilizador, u);
                listaUtilizador.add(u);
            }
			
			// Desconex�o
			conexaoDB.disconnect();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return listaUtilizador;
	
	}
	
	
	/**
	 * Pesquisar utilizador por uid
	 * 
	 * @param String Uid
	 * 
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * 
	 * @return Utilizador
	 */
	public Utilizador getUtilizador(String uid) throws IllegalArgumentException, IllegalAccessException {
		
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		// Tabela de dados
		ResultSet rSetUtilizador = null;

		// Instaciamento do artigo
		Utilizador u = new Utilizador();

		try {
			// Stored Procedure
			CallableStatement stmntGet = con.prepareCall("{call SP_UTILIZADOR_GET(?)}");

			// Atribui��o do parametro do Stored Procedure
			stmntGet.setString(1, uid);

			// Execu��o da query
			rSetUtilizador = stmntGet.executeQuery();

			// Primeira linha
			rSetUtilizador.next();

			if (rSetUtilizador.getRow() == 1) {

				// Convers�o do rSet num objecto
				DBConverter.loadResultSetIntoObject(rSetUtilizador, u);
			}

			// Desconex�o
			conexaoDB.disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;

	}
	
	/**
	 * Contar registo dos utilizador
	 * 
	 * @throws SQLException
	 * @return int
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public int contarUtilizador() throws IllegalArgumentException, IllegalAccessException {
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		try {
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_UTILIZADOR_CONTAR_REGISTOS()}");

			// Execu��o da query
			ResultSet rSetRegistos = stmntList.executeQuery();

			// Extrair o n�mero de registos:
			while (rSetRegistos.next()) {
				return rSetRegistos.getInt(1);
			}

			// Desconex�o
			conexaoDB.disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}
	
	

}
