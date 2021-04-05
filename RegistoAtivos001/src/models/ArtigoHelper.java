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

public class ArtigoHelper {

		
	/**
	*  Cria��o de um artigo
	*  
	*  @param Artigo
	*  @throws SQLException
	*/
	public void criarArtigo(Artigo artigo) 
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Data atual
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		try 
		{
			PreparedStatement stmntCreate = con.prepareCall("{call SP_ARTIGO_CRIAR(?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			// Atribui��o dos valores ao statement
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
	*  Edi��o de um artigo
	*  
	*  @param Artigo
	*  
	*  @throws SQLException
	*  @throws IllegalAccessException 
	*  @throws IllegalArgumentException
	*/
	public Artigo editarArtigo(Artigo artigo) throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � bd
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure:
			CallableStatement stmntEdit = con.prepareCall("{call SP_ARTIGO_EDITAR(?,?,?,?,?,?,?,?,?,?)}");
			
			// Atribui��o dos valores ao statement:
			stmntEdit.setString(1, artigo.getUid());
			stmntEdit.setString(2, artigo.getDescricao());
			stmntEdit.setString(3, artigo.getMarca());
			stmntEdit.setString(4, artigo.getModelo());
			stmntEdit.setString(5, artigo.getNumImobilizado());
			stmntEdit.setString(6, artigo.getNumSerie());
			stmntEdit.setString(7, artigo.getLocalStock());
			stmntEdit.setString(8, artigo.getObs());
			stmntEdit.setString(9, artigo.getFkIdTipoArtigo());
			stmntEdit.setString(10, artigo.getFkIdEstado());
				
			// Execu��o da query:
			stmntEdit.executeQuery();
			
			// Desconex�o:
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
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	*/
	public List<Artigo> listarArtigo() throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Lista de tipos de movimento:
		List<Artigo> listaArtigo = new ArrayList<Artigo>();
		
		// Tabela de dados
		ResultSet rSetArtigo = null;
		
		try 
		{
			// Stored Procedure
			CallableStatement stmntList = con.prepareCall("{call SP_ARTIGO_LISTAR()}");
			
			// Execu��o da query
			rSetArtigo = stmntList.executeQuery();
			
			// Cria��o da lista de objetos:
			while (rSetArtigo.next()) {
				Artigo a = new Artigo();                
                // Convers�o de um registo rSet para um objecto:
                DBConverter.loadResultSetIntoObject(rSetArtigo, a);
                listaArtigo.add(a);
            }
			
			// Desconex�o
			conexaoDB.disconnect();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return listaArtigo;
	
	}
	
	
	
	
	/**
	*  Apagar um artigo
	*  
	*  @param Artigo
	*  @throws SQLException
	*/
	public void apagarArtigo(Artigo artigo)
	{
		// Conex�o � bd
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		try 
		{
			// Stored Procedure
			CallableStatement stmntDelete = con.prepareCall("{call STORED_PROCEDURE_APAGAR_ARTIGO(?)}");
			
			// Atribui��o dos valores ao statement
			stmntDelete.setString(1, "valor ex: artigo.id");
			
			// Execu��o da query
			stmntDelete.executeQuery();
			
			// Desconex�o
			conexaoDB.disconnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	/**
	*  Pesquisar artigo por uid
	*  
	*  @param String Uid
	*  
	*  @throws SQLException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException
	 * 
	 *  @return Artigo
	*/
	public Artigo getArtigo(String uid) throws IllegalArgumentException, IllegalAccessException
	{
		// Conex�o � BD
		ConexaoDB conexaoDB = new ConexaoDB();
		Connection con = conexaoDB.connect();
		
		// Tabela de dados
		ResultSet rSetArtigo = null;
		
		//Instaciamento do artigo
		Artigo a = new Artigo();
		
		try 
		{
			// Stored Procedure
			CallableStatement stmntGet = con.prepareCall("{call SP_ARTIGO_GET(?)}");
			
			// Atribui��o do parametro do Stored Procedure
			stmntGet.setString(1, uid);
			
			// Execu��o da query
			rSetArtigo = stmntGet.executeQuery();
			
			//Primeira linha 
			rSetArtigo.next();
			
			if (rSetArtigo.getRow() == 1)
			{
			
				// Convers�o do rSet num objecto
				DBConverter.loadResultSetIntoObject(rSetArtigo, a);
			}
               
			// Desconex�o
			conexaoDB.disconnect();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return a;
	
	}
	
	
	

}
