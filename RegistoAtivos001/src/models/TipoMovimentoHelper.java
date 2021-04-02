package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoMovimentoHelper {
	
	/**
	*  Obter um estado
	*  
	*  @param ItemLista
	*  @throws SQLException
	*/
	public void criarTipoMovimento(ItemLista TipoMovimento) 
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntCreate = con.prepareCall("{call SP_CRIAR_TIPO_MOVIMENTO(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntCreate.setString(1, "valor ex: estado.id");
			
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
	public List<ItemLista> listarTipoMovimento(ItemLista tipoMovimento) throws IllegalArgumentException, IllegalAccessException 
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
			PreparedStatement stmntList = con.prepareCall("{call SP_LISTAR_TIPO_MOVIMENTO(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntList.setString(1, "valor ex: estado.id");
			
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
		
		// Tabela de dados:
		ResultSet rSetTipoMovimento = null;
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntEdit = con.prepareCall("{call SP_EDITAR_TIPO_MOVIMENTO(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntEdit.setString(1, "valor ex: estado.id");
			
			// Execu��o da query:
			rSetTipoMovimento = stmntEdit.executeQuery();
			
            // Convers�o de um registo rSet para um objecto:
            DBConverter.loadResultSetIntoObject(rSetTipoMovimento, tipoMovimento);    
						
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
	public ItemLista getTipoMovimento(ItemLista tipoMovimento) throws IllegalArgumentException, IllegalAccessException 
	{
		// Conex�o � BD:
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Tabela de dados:
		ResultSet rSetTipoMovimento = null;
		
		try 
		{
			// Stored Procedure:
			PreparedStatement stmntGet = con.prepareCall("{call SP_GET_TIPO_MOVIMENTO(?)}");
			
			// Atribui��o dos valores ao statement:
			stmntGet.setString(1, "valor ex: estado.id");
			
			// Execu��o da query e passagem para o result set:
			rSetTipoMovimento = stmntGet.executeQuery();
			
            // Convers�o de um registo rSet para um objecto:
            DBConverter.loadResultSetIntoObject(rSetTipoMovimento, tipoMovimento);
						
			// Desconex�o:
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tipoMovimento;
		
	}
}
