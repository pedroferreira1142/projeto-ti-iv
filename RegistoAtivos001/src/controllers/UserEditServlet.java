package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Utilizador;
import models.UtilizadorErros;
import models.UtilizadorHelper;
import models.UtilizadorValidator;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// Sess�o do utilizador
		HttpSession session = request.getSession();
		
		response.sendRedirect("views/Utilizador/VerUtilizador.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//doGet(request, response);
		
		// Sess�o do utilizador
		HttpSession session = request.getSession();

		// Instanciamentos
		UtilizadorValidator uV = new UtilizadorValidator();
		UtilizadorErros uE = new UtilizadorErros();
		UtilizadorHelper uH = new UtilizadorHelper();
		Utilizador utilizador = new Utilizador();

		// Valores dos campos submtidos
		String primeiroNome = request.getParameter("primeiroNome");
		String ultimoNome = request.getParameter("ultimoNome");
		String nuc = request.getParameter("nuc");
		String email = request.getParameter("eMail");

		String destPage = "views/Utilizador/VerUtilizador.jsp";
		
		RequestDispatcher dispatcher = null;

		// Se o formul�rio n�o for v�lido
		if (!(uV.checkFormIsValid(primeiroNome, ultimoNome, nuc, email))) //  
		{
			// Verifica��o da nulalidade dos campos
			if (!(uV.checkPrimeiroNomeIsNotNull(primeiroNome)))
				request.setAttribute("messagePrimeiroNome", uE.get_errorPrimeiroNomeNull());
			if (!(uV.checkUltimoNomeIsNotNull(ultimoNome)))
				request.setAttribute("messageUltimoNome", uE.get_errorUltimoNomeNull());
			if (!(uV.checkNucIsNotNull(nuc)))
				request.setAttribute("messageNuc", uE.get_errorNucNull());
			if (!(uV.checkEMailIsNotNull(email)))
				request.setAttribute("messageEMail", uE.get_errorEMailNull());

			// Verifica��o dos requisitos dos campos
			if (!(uV.checkEMailIsValid(email)))
				request.setAttribute("messageEmailInvalid", uE.get_errorEMailNotQualified());

			// Verifica se o utilizador j� tem um e-mail registado na BD
			if (!(uV.checkUserDoesNotExist(email)))
				request.setAttribute("messageUserAlreadyExists", uE.get_errorUserAlreadyExists());

			// Redireciona para a p�gina login
			dispatcher = request.getRequestDispatcher(destPage);
		}
		// Se o formul�rio for v�lido
		else 
		{
			// Try Cacth da cria��o do utilizador
			try 
			{

				// Atribui��o dos atributos do utilizador
				utilizador.setPrimeiroNome(primeiroNome);
				utilizador.setUltimoNome(ultimoNome);
				utilizador.setNuc(nuc);
				utilizador.seteMail(email);

				// Cria��o do utilizador
				uH.editarUtilizador(utilizador);
				Utilizador uEditado = uH.getUtilizadorByEMail(email);
				
				session.setAttribute("user", uEditado);

				request.setAttribute("message", "Informa��es atualizadas");
				
			} 
			catch (IllegalArgumentException | IllegalAccessException ex) 
			{
				throw new ServletException(ex);
			}

			// Redireciona para a p�gina login
			dispatcher = request.getRequestDispatcher("index.jsp");

		}
		
		dispatcher.forward(request, response);

	}

}
