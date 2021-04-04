package models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EstadoHelper {
	/**
	*  Criar um Estado
	*  
	*  @param ItemLista
	*  @throws SQLException
	*/
	public void criarEstado(ItemLista estado) 
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// UUID
		String uniqueID = null;
		try 
		{
			// Stored Procedure
			PreparedStatement stmntCreate = con.prepareCall("{call SP_ESTADO_CRIAR(?, ?)}");
			
			// Atribui��o dos valores ao statement
			stmntCreate.setString(1, uniqueID = UUID.randomUUID().toString());
			stmntCreate.setString(2, estado.getItem());
			
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
	*  Editar um estado
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @return ResultSet ItemLista
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException
	*/
	public ItemLista editarEstado(ItemLista estado) throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure
			PreparedStatement stmntEdit = con.prepareCall("{call SP_ESTADO_EDITAR(?, ?)}");
			
			// Atribui��o dos valores ao statement
			stmntEdit.setString(1, estado.getUid());
			stmntEdit.setString(2, estado.getItem());
			
			// Execu��o da query
			stmntEdit.executeQuery();
			
			// Desconex�o
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return estado;
	}
	
	
	/**
	*  Listagem de Estados
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @return List ItemLista
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException 
	*/
	public List<ItemLista> listarEstado() throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Lista de tipos de movimento:
		List<ItemLista> listaEstado = new ArrayList<ItemLista>();
		
		// Tabela de dados
		ResultSet rSetEstado = null;
		
		try 
		{
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_ESTADO_LISTAR()}");
			
			// Execu��o da query
			rSetEstado = stmntList.executeQuery();			
				
			// Cria��o da lista de objetos:
			while (rSetEstado.next()) {
				ItemLista item = new ItemLista();                
                // Convers�o de um registo rSet para um objecto:
                DBConverter.loadResultSetIntoObject(rSetEstado, item);
                listaEstado.add(item);
            }
			
			// Desconex�o
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return listaEstado;
	}
	
	
	/**
	*  Obter um estado
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @return ResultSet ItemLista
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException
	*/
	public ItemLista getEstado(String uidEstado) throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		ItemLista estado = new ItemLista();
		
		// Tabela de dados
		ResultSet rSetEstado = null;
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntGet = con.prepareCall("{call SP_ESTADO_GET(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntGet.setString(1, uidEstado);
			
			// Execu��o da query:
			rSetEstado = stmntGet.executeQuery();
			
			// Mover o cursos para o primeiro index 
			rSetEstado.next();
			
			// Convers�o de um resultSet para um (objecto)estado:
			DBConverter.loadResultSetIntoObject(rSetEstado, estado);
						
			// Desconex�o:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return estado;
	}
	
	
	
	
}
