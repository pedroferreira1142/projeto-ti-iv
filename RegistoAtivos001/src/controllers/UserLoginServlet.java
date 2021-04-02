package controllers;

import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import models.*;

/**
 * Implementação Servlet de Login
 * Class LoginServlet
 * 
 */
@WebServlet("/LoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	public UserLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * Compara os dados de Login introduzidos com os dados da Base de Dados
	 * 
	 * @throws ServletException 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAcessException
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// E-mail e password do request
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UtilizadorHelper eHelper = new UtilizadorHelper();
		
		// Verifica a nuladidade dos campos
		if (email == null || password  == null || email == "" || password == "")
		{
			String destPage = "login.jsp";
			
			// Mensagem de erro
			String message = "Nenhum dos campos podem estar nulos.";
			request.setAttribute("message", message);
			
			// Redireciona para a página login
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
		}
		
		try 
		{
			// Verificação dos dados de login na Base de dados:
			Utilizador utilizador = eHelper.checkLogin(email, password);
			String destPage = "login.jsp";

			// Verifica se o uid é válido
			if (utilizador.getUid() != "00000000-0000-0000-0000-000000000000") 
			{	
				// Cria a sessão
				HttpSession session = request.getSession();
				session.setAttribute("user", utilizador);
				destPage = "index.jsp";			
			}
			// Retorna o erro, em caso de login errado:
			else
			{
				String message = "E-mail ou password inválidos!";
				request.setAttribute("message", message);
			}

			// Define um objecto para ser enviado para a página de login(destPAge)
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);

		} catch (SQLException | ClassNotFoundException 
				| IllegalArgumentException | IllegalAccessException 
				| NoSuchAlgorithmException | InvalidKeySpecException ex) 
		{
			throw new ServletException(ex);
		}
	}

}
