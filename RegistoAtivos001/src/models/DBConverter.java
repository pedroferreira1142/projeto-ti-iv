package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.reflect.Field;
import java.lang.Object;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DBConverter {
	
	
	/**
	* Converter um record de um ResultSet num objecto 
	*  
	*  @param ResultSet, Object
	*  
	*/
	public static void loadResultSetIntoObject(ResultSet rst, Object object)
	        throws IllegalArgumentException, IllegalAccessException, SQLException {
	    
		// Recebe a class do objeto instanciado:
		Class<?> zclass = object.getClass();
		
		// Para cada atributo da classe:
	    for (Field field : zclass.getDeclaredFields()) {
	        
	    	// Tornar o atributo acessível:
	    	field.setAccessible(true);
	    	// Retorna a anotação da DataBase Table:
	    	DBTable coluna = field.getAnnotation(DBTable.class);
	    	// Retorna o valor da coluna designada do ResultSet:
	    	Object valor = rst.getObject(coluna.nomeColuna());
	        // Retorna o tipo do atributo:
	    	Class<?> tipo = field.getType();
	    	
	        // Determina se o tipo de variável é primitiva:
	        if (isPrimitive(tipo)) {
	        	// Retorna a classe da primitiva (ex: Integer.class):
	            Class<?> boxed = boxPrimitiveClass(tipo);
	            // Cast do objecto(valor rSet) para o respectivo tipo do atributo(Classe):
	            valor = boxed.cast(valor);
	        }
	        field.set(object, valor);
	    }
	}
	
	
	/**
	* Determina se a Classe é de tipo Primitiva 
	*  
	*  @param Class<?> type
	*  @return Boolean (Se é primitiva ou não)
	*/
	public static boolean isPrimitive(Class<?> type) {
	    return (type == int.class || type == long.class || type == double.class || type == float.class
	            || type == boolean.class || type == byte.class || type == char.class || type == short.class);
	}
	
	
	/**
	* Retorna a Classe Primitva do atributo(Boxing)
	*  
	*  @param Class <?> type
	*  
	*/
	public static Class<?> boxPrimitiveClass(Class<?> type) {
	    // Determina a primitiva e retorna a classe dessa primitiva:
		if (type == int.class) 
	        return Integer.class; 
		else if (type == long.class) 
	        return Long.class;
		else if (type == double.class) 
	        return Double.class;
		else if (type == float.class) 
	        return Float.class;
		else if (type == boolean.class) 
	        return Boolean.class;
		else if (type == byte.class) 
	        return Byte.class; 
		else if (type == char.class) 
	        return Character.class;
	    else if (type == short.class) 
	        return Short.class; 
		else 
	    {
	    	// Se não for uma classe do tipo primitiva, lança um erro:
	        String string = "class '" + type.getName() + "' is not a primitive";
	        throw new IllegalArgumentException(string);
	    }
	}
	
	
	/**
	*  Anotação da classe DBTable
	*  
	*  @param RetentionPolicy
	*/
	@Retention(RetentionPolicy.RUNTIME)
	public @interface DBTable {
		public String nomeColuna();
	}
}
