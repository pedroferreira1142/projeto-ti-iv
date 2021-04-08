package models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TipoArtigoHelper {
	
	/**
	*  Criar um Tipo de Artigo
	*  
	*  @param ItemLista
	*  @throws SQLException
	*/
	public void criarTipoArtigo(ItemLista tipoArtigo) 
	{
		// UUID
		String uniqueID = null;
		
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure
			PreparedStatement stmntCreate = con.prepareCall("{call SP_TIPO_ARTIGO_CRIAR(?,?)}");
			
			// Atribui��o dos valores ao statement
			stmntCreate.setString(1, uniqueID = UUID.randomUUID().toString());
			stmntCreate.setString(2, tipoArtigo.getItem());
			
			// Execu��o da query
			stmntCreate.executeQuery();
						
			// Desconex�o
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	
	/**
	*  Editar um Tipo de Artigo
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException
	*/
	public ItemLista editarTipoArtigo(ItemLista tipoArtigo) throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure
			PreparedStatement stmntEdit = con.prepareCall("{call SP_TIPO_ARTIGO_EDITAR(?, ?)}");
			
			// Atribui��o dos valores ao statement
			stmntEdit.setString(1, tipoArtigo.getUid());
			stmntEdit.setString(2, tipoArtigo.getItem());
			
			// Execu��o da query
			stmntEdit.executeQuery();
			
			// Desconex�o
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tipoArtigo; 
	}
	
	
	/**
	*  Listagem de Tipos de Artigo
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @return ResultSet ItemLista
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	*/
	public List<ItemLista> listarTipoArtigo() throws IllegalArgumentException, IllegalAccessException 
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Lista de tipos de movimento:
		List<ItemLista> listaTipoArtigo = new ArrayList<ItemLista>();
		
		// Tabela de dados
		ResultSet rSetTipoArtigo = null;
		
		try 
		{
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_TIPO_ARTIGO_LISTAR()}");
			
			// Execu��o da query
			rSetTipoArtigo = stmntList.executeQuery();
			
			// Cria��o da lista de objetos:
			while (rSetTipoArtigo.next()) 
			{
				ItemLista item = new ItemLista();                
                // Convers�o de um registo rSet para um objecto:
                DBConverter.loadResultSetIntoObject(rSetTipoArtigo, item);
                listaTipoArtigo.add(item);
            }

						
			// Desconex�o
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return listaTipoArtigo;
	}
	
	
	/**
	*  Obter um tipo de Artigo
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @return ItemLista
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException
	*/
	public ItemLista getTipoArtigo(String uidTipoArtigo) throws IllegalArgumentException, IllegalAccessException
	{

		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		ItemLista tipoArtigo = new ItemLista();
		
		// Tabela de dados
		ResultSet rSetEstado = null;
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntGet = con.prepareCall("{call SP_TIPO_ARTIGO_GET(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntGet.setString(1, uidTipoArtigo);
			
			// Execu��o da query:
			rSetEstado = stmntGet.executeQuery();
			
			// Mover o cursos para o primeiro index 
			rSetEstado.next();
			
			// Convers�o de um resultSet para um (objecto)estado:
			DBConverter.loadResultSetIntoObject(rSetEstado, tipoArtigo);
						
			// Desconex�o:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return tipoArtigo;
	}
	
	
	/**
	*  Apagar um tipo de artigo
	*  
	*  @param String Uid
	*  @return void
	*  
	*  @throws SQLException
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException
	*/
	public void apagarTipoArtigo(String uidTipoArtigo) throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntGet = con.prepareCall("{call SP_TIPO_ARTIGO_APAGAR(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntGet.setString(1, uidTipoArtigo);
			
			// Execu��o da query:
			stmntGet.executeQuery();
						
			// Desconex�o:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
