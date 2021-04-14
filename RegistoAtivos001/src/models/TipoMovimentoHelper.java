package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TipoMovimentoHelper {
	
	/**
	*  Criar um Tipo de movimento
	*  
	*  @param ItemLista
	*  @throws SQLException
	*/
	public void criarTipoMovimento(ItemLista tipoMovimento) 
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// UUID
		String uniqueID = null;
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntCreate = con.prepareCall("{call SP_TIPO_MOVIMENTO_CRIAR(?,?)}");
			
			// Atribui��o dos valores ao statement:
			stmntCreate.setString(1, uniqueID = UUID.randomUUID().toString());
			stmntCreate.setString(2, tipoMovimento.getItem());
			
			// Execu��o da query:
			stmntCreate.executeQuery();
						
			// Desconex�o:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	/**
	*  Listagem de Tipos de Movimento
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @return ResultSet ItemLista
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	*/
	public List<ItemLista> listarTipoMovimento() throws IllegalArgumentException, IllegalAccessException 
	{
		// Conex�o � BD:
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Lista de tipos de movimento:
		List<ItemLista> listaTipoMovimento = new ArrayList<ItemLista>();
		
		// Tabela de dados:
		ResultSet rSetTipoMovimento = null;
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntList = con.prepareCall("{call SP_TIPO_MOVIMENTO_LISTAR()}");
			
			// Execu��o da query:
			rSetTipoMovimento = stmntList.executeQuery();
			
			// Cria��o da lista de objetos:
			while (rSetTipoMovimento.next()) {
                ItemLista item = new ItemLista();
                // Convers�o de um registo rSet para um objecto:
                DBConverter.loadResultSetIntoObject(rSetTipoMovimento, item);
                listaTipoMovimento.add(item);
            }
						
			// Desconex�o:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listaTipoMovimento;
		
	}
	
	
	/**
	*  Editar um Tipo de Movimento
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @return ResultSet ItemLista
	* @throws IllegalAccessException 
	* @throws IllegalArgumentException 
	*/
	public ItemLista editarTipoMovimento(ItemLista tipoMovimento) throws IllegalArgumentException, IllegalAccessException 
	{
		// Conex�o � BD:
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntEdit = con.prepareCall("{call SP_TIPO_MOVIMENTO_EDITAR(?,?)}");
			
			// Atribui��o dos valores ao statement:
			stmntEdit.setString(1, tipoMovimento.getUid());
			stmntEdit.setString(2, tipoMovimento.getItem());
			
			// Execu��o da query:
			stmntEdit.executeQuery();    
						
			// Desconex�o:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tipoMovimento;
		
	}
	
	
	/**
	*  Retirar um Tipo de Movimento
	*  
	*  @param ItemLista
	*  @throws SQLException
	*  @return ResultSet ItemLista
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException 
	*/
	public ItemLista getTipoMovimento(String uidTipoMovimento) throws IllegalArgumentException, IllegalAccessException 
	{
		// Conex�o � BD:
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		ItemLista tipoMovimento = new ItemLista();
		
		// Tabela de dados:
		ResultSet rSetTipoMovimento = null;
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntGet = con.prepareCall("{call SP_TIPO_MOVIMENTO_GET(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntGet.setString(1, uidTipoMovimento);
			
			// Execu��o da query e passagem para o result set:
			rSetTipoMovimento = stmntGet.executeQuery();
			
			// Primeira linha
			rSetTipoMovimento.next();
			
			if (rSetTipoMovimento.getRow() == 1) {

				// Convers�o de um registo rSet para um objecto:
	            DBConverter.loadResultSetIntoObject(rSetTipoMovimento, tipoMovimento);
			}
						
			// Desconex�o:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tipoMovimento;
		
	}
	
	
	/**
	*  Apagar um tipo de movimento
	*  
	*  @param String Uid
	*  @return void
	*  
	*  @throws SQLException
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException
	*/
	public void apagarTipoMovimento(String uidTipoMovimento) throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntGet = con.prepareCall("{call SP_TIPO_MOVIMENTO_APAGAR(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntGet.setString(1, uidTipoMovimento);
			
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
