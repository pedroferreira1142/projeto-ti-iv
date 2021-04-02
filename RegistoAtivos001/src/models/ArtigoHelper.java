package models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.sql.PreparedStatement;

public class ArtigoHelper {

		
	/**
	*  Criação de um artigo
	*  
	*  @param Artigo
	*  @throws SQLException
	*/
	public void criarArtigo(Artigo artigo) 
	{
		// Conexão à BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Data atual
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		try 
		{
			PreparedStatement stmntCreate = con.prepareCall("{call SP_ARTIGO_CRIAR(?,?,?,?,?,?,?,?,?,?,?)}");
			
			// Atribuição dos valores ao statement
			stmntCreate.setString(1, UUID.randomUUID().toString());
			stmntCreate.setString(2, artigo.getDescricao());
			stmntCreate.setString(3, artigo.getMarca());
			stmntCreate.setString(4, artigo.getModelo());
			stmntCreate.setString(5, artigo.getNumImobilizado());
			stmntCreate.setString(6, artigo.getNumSerie());
			stmntCreate.setString(7, artigo.getLocalStock());
			stmntCreate.setString(8, artigo.getObs());
			stmntCreate.setDate(9, sqlDate);
			stmntCreate.setString(10, artigo.getFkIdUtilizador());
			stmntCreate.setString(11, artigo.getFkIdTipoArtigo());
			stmntCreate.setString(12, artigo.getFkIdEstado());
			
			
			// Execução da query
			stmntCreate.executeQuery();
						
			// Desconexão
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	/**
	*  Edição de um artigo
	*  
	*  @param Artigo
	*  @throws SQLException
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException
	*/
	public Artigo editarArtigo(Artigo artigo) throws IllegalArgumentException, IllegalAccessException
	{
		// Conexão à bd
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Tabela de dados
		ResultSet rSetEstado = null;
		
		try 
		{
			// Stored Procedure:
			CallableStatement stmntEdit = con.prepareCall("{call STORED_PROCEDURE_EDITAR(?)}");
			
			// Atribuição dos valores ao statement:
			stmntEdit.setString(1, "valor ex: artigo.descricao");
				
			// Execução da query:
			stmntEdit.executeQuery();
			
			// Conversão do resultSet para um (objecto)Artigo:
			if (rSetEstado.getRow() == 1)
				DBConverter.loadResultSetIntoObject(rSetEstado, artigo);
			else
				// Throws error
			
			// Desconexão:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return artigo;
	}
	
	
	/**
	*  Listar artigos
	*  
	*  @param Artigo
	*  @throws SQLException
	*  @return listagem artigos
	*/
	public ResultSet listarArtigo()
	{
		// Conexão à DB
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Tabela de dados
		ResultSet rSetListar = null;
		
		try 
		{
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call STORED_PROCEDURE_LISTAR()}");
			
			// Execução da query
			rSetListar = stmntList.executeQuery();
			
			// Desconexão
			conexaoDB.disconnect();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return rSetListar;
	
	}
	
	
	
	
	/**
	*  Apagar um artigo
	*  
	*  @param Artigo
	*  @throws SQLException
	*/
	public void apagarArtigo(Artigo artigo)
	{
		// Conexão à bd
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure
			CallableStatement stmntDelete = con.prepareCall("{call STORED_PROCEDURE_APAGAR_ARTIGO(?)}");
			
			// Atribuição dos valores ao statement
			stmntDelete.setString(1, "valor ex: artigo.id");
			
			// Execução da query
			stmntDelete.executeQuery();
			
			// Desconexão
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	
	

}
