package models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MovimentoHelper {
	
	
	/**
	 * Cria��o de um movimento
	 * 
	 * @param Movimento
	 * @throws SQLException
	 */
	public void criarMovimento(Movimento mov) {
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		// Data atual
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		try {
			PreparedStatement stmntCreate = con.prepareCall("{call SP_MOVIMENTO_CRIAR(?,?,?,?,?,?,?,?,?)}");

			// Atribui��o dos valores ao statement
			stmntCreate.setString(1, UUID.randomUUID().toString());
			stmntCreate.setDate(2, sqlDate);
			stmntCreate.setString(3, mov.getLocalStock());
			stmntCreate.setString(4, mov.getColaboradorNuc());
			stmntCreate.setString(5, mov.getNomeColaborador());
			stmntCreate.setString(6, mov.getObs());
			stmntCreate.setString(7, mov.getUidArtigo());
			stmntCreate.setString(8, mov.getUidUtilizador());
			stmntCreate.setString(9, mov.getUidTipoMovimento());

			// Execu��o da query
			stmntCreate.executeQuery();

			// Desconex�o
			conexaoDB.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * Edi��o de um movimento
	 * 
	 * @param Movimento
	 * 
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public void editarMovimento(Movimento mov) throws IllegalArgumentException, IllegalAccessException {
		// Conex�o � bd
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		try {
			// Stored Procedure:
			CallableStatement stmntEdit = con.prepareCall("{call SP_MOVIMENTO_EDITAR(?,?,?,?,?)}");

			// Atribui��o dos valores ao statement
			stmntEdit.setString(3, mov.getLocalStock());
			stmntEdit.setString(4, mov.getColaboradorNuc());
			stmntEdit.setString(5, mov.getNomeColaborador());
			stmntEdit.setString(6, mov.getObs());
			stmntEdit.setString(9, mov.getUidTipoMovimento());

			// Execu��o da query:
			stmntEdit.executeQuery();

			// Desconex�o:
			conexaoDB.disconnect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Listar movimentos
	 * 
	 * @param Movimento
	 * @throws SQLException
	 * @return listagem artigos
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public List<Movimento> listarMovimento() throws IllegalArgumentException, IllegalAccessException {
		
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		// Lista de tipos de movimento:
		List<Movimento> listaMovimento = new ArrayList<Movimento>();

		// Tabela de dados
		ResultSet rSetMovimento = null;

		try {
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_MOVIMENTO_LISTAR()}");
			
			// Execu��o da query
			rSetMovimento = stmntList.executeQuery();

			// Cria��o da lista de objetos:
			while (rSetMovimento.next()) {
				Movimento m = new Movimento();
				// Convers�o de um registo rSet para um objecto:
				DBConverter.loadResultSetIntoObject(rSetMovimento, m);
				listaMovimento.add(m);
			}

			// Desconex�o
			conexaoDB.disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaMovimento;

	}
	
	/**
	 * Listar movimentos por artigo (Overloading)
	 * 
	 * @param Movimento
	 * @throws SQLException
	 * @return listagem artigos
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public List<Movimento> listarMovimento(String uidArtigo) throws IllegalArgumentException, IllegalAccessException {
		
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		// Lista de tipos de movimento:
		List<Movimento> listaMovimento = new ArrayList<Movimento>();

		// Tabela de dados
		ResultSet rSetMovimento = null;

		try {
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_MOVIMENTO_POR_ARTIGO(?)}");

			// Atribui��o dos valores ao statement
			stmntList.setString(1, uidArtigo);
			
			// Execu��o da query
			rSetMovimento = stmntList.executeQuery();

			// Cria��o da lista de objetos:
			while (rSetMovimento.next()) {
				
				Movimento m = new Movimento();
				// Convers�o de um registo rSet para um objecto:
				DBConverter.loadResultSetIntoObject(rSetMovimento, m);
				listaMovimento.add(m);
			}

			// Desconex�o
			conexaoDB.disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaMovimento;

	}
	
	/**
	 * Lista de todos os movimentos ordenados por data, de forma descendente
	 * 
	 * @param Movimento
	 * @return listagem artigos
	 * 
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public List<Movimento> listarMovimentoPorData() throws IllegalArgumentException, IllegalAccessException {
		
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		// Lista de tipos de movimento:
		List<Movimento> listaMovimento = new ArrayList<Movimento>();

		// Tabela de dados
		ResultSet rSetMovimento = null;

		try {
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_MOVIMENTO_LISTAR_POR_DATA()}");
			
			// Execu��o da query
			rSetMovimento = stmntList.executeQuery();

			// Cria��o da lista de objetos:
			while (rSetMovimento.next()) 
			{
				Movimento m = new Movimento();
				// Convers�o de um registo rSet para um objecto:
				DBConverter.loadResultSetIntoObject(rSetMovimento, m);
				listaMovimento.add(m);
			}

			// Desconex�o
			conexaoDB.disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaMovimento;

	}
	
	
	/**
	 * Pesquisar movimento por uid
	 * 
	 * @param String Uid
	 * 
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * 
	 * @return Movimento
	 */
	public Movimento getMovimento(String uid) throws IllegalArgumentException, IllegalAccessException {
		
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		// Tabela de dados
		ResultSet rSetMovimento = null;

		// Instaciamento do artigo
		Movimento m = new Movimento();

		try {
			// Stored Procedure
			CallableStatement stmntGet = con.prepareCall("{call SP_MOVIMENTO_GET(?)}");

			// Atribui��o do parametro do Stored Procedure
			stmntGet.setString(1, uid);

			// Execu��o da query
			rSetMovimento = stmntGet.executeQuery();

			// Primeira linha
			rSetMovimento.next();

			if (rSetMovimento.getRow() == 1) {

				// Convers�o do rSet num objecto
				DBConverter.loadResultSetIntoObject(rSetMovimento, m);
			}

			// Desconex�o
			conexaoDB.disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return m;

	}
	
	/**
	 * Listar movimentos, registos mais recentes
	 * 
	 * @param Movimento
	 * @throws SQLException
	 * @return listagem artigos
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public List<Movimento> listarMovimentoRecentes() throws IllegalArgumentException, IllegalAccessException {
		
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		// Lista de tipos de movimento:
		List<Movimento> listaMovimento = new ArrayList<Movimento>();

		// Tabela de dados
		ResultSet rSetMovimento = null;

		try {
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_MOVIMENTO_LISTAR_RECENTES()}");
			
			// Execu��o da query
			rSetMovimento = stmntList.executeQuery();

			// Cria��o da lista de objetos:
			while (rSetMovimento.next()) {
				Movimento m = new Movimento();
				// Convers�o de um registo rSet para um objecto:
				DBConverter.loadResultSetIntoObject(rSetMovimento, m);
				listaMovimento.add(m);
			}

			// Desconex�o
			conexaoDB.disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaMovimento;

	}
	
	
	/**
	 * Contar registo dos movimentos
	 * 
	 * @throws SQLException
	 * @return int num de registos
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public int contarMovimento() throws IllegalArgumentException, IllegalAccessException {
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();

		try {
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_MOVIMENTO_CONTAR_REGISTOS()}");

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
