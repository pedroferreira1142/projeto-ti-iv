package models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class ConexaoDB
{

    // Instanciar as contantes da Base de dados
    private static final String dataBaseDriver = "com.mysql.cj.jdbc.Driver";
    private static final String dataBaseURL = "jdbc:mysql://localhost:3306/plataformaativos";
    private static final String username = "root";
    private static final String password = "pass2142";
    private static final String maxPool = "250";

    // Instanciamento do objeto de conexão
    private Connection connection;
    
    // Instanciamento do objeto de propriedades
    private Properties properties;

    // Instanciamento do objeto statement
    private Statement statement;
    
    // Criar a stream de propriedades
    private Properties getProperties() 
    {    	
        if (properties == null)
        {
            properties = new Properties();
        
            properties.setProperty("user", username);
            
            properties.setProperty("password", password);
            
            properties.setProperty("MaxPooledStatements", maxPool);
        }
        
        return properties;
    }

    
    /**** 
     * Conexão com a Base de dados 
     ****/
    public Connection connect() 
    {    	
        if (connection == null)
        {         
            try
            {
            	// Retorna a classe associada ao driver JBDC
                Class.forName(dataBaseDriver);
                
                //  Conexão com a Base de dados
                connection = (Connection) DriverManager.getConnection(dataBaseURL, getProperties());
            }
            catch (ClassNotFoundException | SQLException e)
            {
                e.printStackTrace(); //Print do erro
            }
        }
        return connection;
    }

    
    /**
     * Desconexão com a Base de dados
     */
    public void disconnect() 
    {    	
        if (connection != null)
        {
            try
            {
                connection.close();
             
                connection = null;
                
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Retorna o result set quando um statement é executado
     * 
     * @parametros SQLQuery
     * @retorna resultSet (tabela de registos originada da query)
     * @throws SQLException 
     */
    public ResultSet select(String query) throws SQLException
    {        
        statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery(query);
        
        return resultSet;        
    }
    
    /**
     * Retorna o status quando é executada uma query de CRUD
     * 
     * @parametros query
     * @retorna status
     * @throws SQLException 
     */
    public int createOrUpdateOrDelete(String query) throws SQLException
    {        
            statement = connection.createStatement(); // Cria o statement
            
            int result = statement.executeUpdate(query); // Retorna o número de colunas afetadas pelo statement
            
            return result;       
    }
    
}