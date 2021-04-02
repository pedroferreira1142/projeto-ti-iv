package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;

/**
 * Servlet implementation class EditPasswordServlet
 */
@WebServlet("/EditPasswordServlet")
public class UserEditPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Sessão do utilizador
		HttpSession session = request.getSession();
		response.sendRedirect("views/Utilizador/MudarPasswordUtilizador.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// doGet(request, response);
		// Sessão do utilizador
		HttpSession session = request.getSession();

		// Instaciamentos
		UtilizadorValidator uV = new UtilizadorValidator();
		UtilizadorErros uE = new UtilizadorErros();
		UtilizadorHelper uH = new UtilizadorHelper();
		Utilizador utilizador = (Utilizador) session.getAttribute("user");
		PasswordEncryption pE = new PasswordEncryption();

		// Valores dos campos submtidos
		String passwordAntiga = request.getParameter("passwordAntiga");
		String password = request.getParameter("password");
		String confirmarPassword = request.getParameter("confirmarPassword");
		
		// Página login
		String destPage = "views/Utilizador/VerUtilizador.jsp";
		
		if (!(uV.checkFormIsValid(passwordAntiga, password, confirmarPassword))) 
		{
			// Verificação dos requisitos dos campos
			if (!(uV.checkPasswordIsValid(password)))
				request.setAttribute("messagePasswordInvalid", uE.get_errorPasswordNotQualified());
			if (!(uV.checkPasswordConfirmationMatches(password, confirmarPassword)))
				request.setAttribute("messagePasswordDoesNotMatch", uE.get_errorPasswordDoesNotMatch());
			if (!(uV.checkPasswordIsNotNull(password)))
				request.setAttribute("messagePassword", uE.get_errorPasswordNull());

			// Redireciona para a página login
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
		}
		else
		{			
			// Verificação da password introduzida com o registo da base de dados
			try 
			{
				if (pE.autenticacao(passwordAntiga, utilizador.getPassword(), utilizador.getPasswordSalt()));
					uH.changePassword(password, utilizador.getUid());
			} 
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			} 
			catch (InvalidKeySpecException e) 
			{
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Redireciona para a página login
		RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
		dispatcher.forward(request, response);
		
		
	}

}
