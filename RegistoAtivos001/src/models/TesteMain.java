package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class TesteMain {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, SQLException {
		ItemLista item = new ItemLista();
		EstadoHelper eHelper = new EstadoHelper();
		UtilizadorHelper uHelper = new UtilizadorHelper(); 
		Utilizador u = new Utilizador();
		
		// u.seteMail("pedroferreira1142@gmail.com");
		
		// System.out.print(uHelper.getUtilizadorByEMail(u).getPrimeiroNome());
		// item.setItem("teste_mod_2");
		// item.setUid("308363d2-24bb-4f95-808b-57efef101c37");
		// eHelper.criarEstado(item);
		//eHelper.editarEstado(item);
		// List<ItemLista> listaEstados = new ArrayList<ItemLista>();
		// listaEstados = eHelper.listarEstado();
		
		// System.out.print(UtilizadorValidator.checkEMail("teste@mail.com"));
		// System.out.print(UtilizadorValidator.checkPassword("Pedro_2142#"));
		
		
		//System.out.print(eHelper.getEstado(item).getItem());
		
		//System.out.print(uHelper.checkLogin("teste", "teste").getUid());
		
		// for (ItemLista estado : listaEstados)
		// {
			// System.out.print(estado.getItem());
		//}

		
		/*ConexaoDB con = new ConexaoDB();
		try 
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plataformaativos", "root", "pedro2142");
			System.out.print("Sucesso");
		}
		catch (SQLException e)
		{
			System.out.print("Erro");
		}*/
		
		

	}

}
