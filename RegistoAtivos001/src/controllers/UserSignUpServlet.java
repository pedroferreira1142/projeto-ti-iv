package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.*;

/**
 * Implementação de SignUp Servlet
 * Class SignUpServlet
 */

@WebServlet("/SignUpServlet")
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpServlet() {
        super();
    }

	/**
	 * Retorna a página de criação de um utilizador
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * @throws ServletException
	 * @throws IOException
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/Utilizador/CriarUtilizador.jsp").forward(request, response);
	}

	/**
	 * Submissão dos dados do formuláio
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Instaciamentos
		UtilizadorValidator uV = new UtilizadorValidator();		
		UtilizadorErros uE = new UtilizadorErros();
		UtilizadorHelper uH = new UtilizadorHelper();
		Utilizador utilizador = new Utilizador();
		
		String primeiroNome = request.getParameter("primeiroNome");
		String ultimoNome =  request.getParameter("ultimoNome");
		String nuc = request.getParameter("nuc");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmarPassword = request.getParameter("confirmarPassword");		
		
		// Página login
		String destPage = "views/Utilizador/CriarUtilizador.jsp";
		
		// Se o formulário não for válido
		if (!(uV.checkFormIsValid(primeiroNome, ultimoNome, nuc, password, confirmarPassword, email)))
		{
			// Verificação da nulalidade dos campos
			if (!(uV.checkPrimeiroNomeIsNotNull(primeiroNome)))
				request.setAttribute("messagePrimeiroNome", uE.get_errorPrimeiroNomeNull());
			if (!(uV.checkUltimoNomeIsNotNull(ultimoNome)))
				request.setAttribute("messageUltimoNome", uE.get_errorUltimoNomeNull());
			if (!(uV.checkNucIsNotNull(nuc)))
				request.setAttribute("messageNuc", uE.get_errorNucNull());
			if (!(uV.checkEMailIsNotNull(email)))
				request.setAttribute("messageEMail", uE.get_errorEMailNull());
			if (!(uV.checkPasswordIsNotNull(password)))
				request.setAttribute("messagePassword", uE.get_errorPasswordNull());
			if (!(uV.checkPasswordConfirmationIsNotNull(confirmarPassword)))
				request.setAttribute("messagePasswordConfirmation", uE.get_errorPasswordConfirmationNull());
			
			// Verificação dos requisitos dos campos
			if (!(uV.checkEMailIsValid(email)))
				request.setAttribute("messageEmailInvalid", uE.get_errorEMailNotQualified());
			if (!(uV.checkPasswordIsValid(password)))
				request.setAttribute("messagePasswordInvalid", uE.get_errorPasswordNotQualified());
			if (!(uV.checkPasswordConfirmationMatches(password, confirmarPassword)))
				request.setAttribute("messagePasswordDoesNotMatch", uE.get_errorPasswordDoesNotMatch());
			
			// Verifica se o utilizador já tem um e-mail registado na BD
			if (!(uV.checkUserDoesNotExist(email)))
				request.setAttribute("messageUserAlreadyExists", uE.get_errorUserAlreadyExists());

			// Redireciona para a página login
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
		}
		// Se o formulário for válido
		else 
		{
			// Try Cacth da criação do utilizador
			try
			{
				// Atribuição dos atributos do utilizador
				utilizador.setPrimeiroNome(primeiroNome);
				utilizador.setUltimoNome(ultimoNome);
				utilizador.setNuc(nuc);
				utilizador.seteMail(email);
				utilizador.setPassword(password.getBytes());
				
				// Criação do utilizador
				uH.criarUtilizador(utilizador);
				
				request.setAttribute("message", "Novo utilizador criado");
			}
			catch (IllegalArgumentException ex ) 
			{
				throw new ServletException(ex);
			}
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			}
			catch (InvalidKeySpecException e) 
			{
				e.printStackTrace();
			}
				
			// Redireciona para a página login
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
		}
	}
	

}
