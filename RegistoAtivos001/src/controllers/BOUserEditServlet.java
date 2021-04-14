package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;

/**
 * Servlet implementation class BOUserEditServlet
 */
@WebServlet("/BOUserEditServlet")
public class BOUserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOUserEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Instaciamentos
		UtilizadorHelper uH = new UtilizadorHelper();
		Utilizador u = new Utilizador();
		
		// Atributos do request
		String eMailUtilizador = request.getParameter("eMailUtilizador");
			
		try
		{
			// Extrair o utilizador por e-mail
			u = uH.getUtilizadorByEMail(eMailUtilizador);
			
			// Envia o utilizador para a view
			request.setAttribute("utilizador", u);
		}
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/BackOffice/BOEditarUtilizador.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Sessão do utilizador
		HttpSession session = request.getSession();

		// Instanciamentos
		Validator v = new Validator();
		ValidatorErrorMessages vEM = new ValidatorErrorMessages();
		UtilizadorHelper uH = new UtilizadorHelper();
		Utilizador utilizador = new Utilizador();

		// Valores dos campos submtidos
		String primeiroNome = request.getParameter("primeiroNome");
		String ultimoNome = request.getParameter("ultimoNome");
		String nuc = request.getParameter("nuc");
		String email = request.getParameter("eMail");

		RequestDispatcher dispatcher = null;
		String destPage = "views/Utilizador/BOEditarUtilizador.jsp";
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();		
		campos.add(primeiroNome);
		campos.add(ultimoNome);
		campos.add(nuc);
		campos.add(email);

		if (v.checkFieldListAreNull(campos))
		{
			request.setAttribute("message", vEM.get_errorNotNull());
			dispatcher = request.getRequestDispatcher("views/BackOffice/BOEditarUtilizador.jsp");
		}
		// Se o formulário for válido
		else
		{
			// Try Cacth da criação do utilizador
			try {

				// Atribuição dos atributos do utilizador
				utilizador.setPrimeiroNome(primeiroNome);
				utilizador.setUltimoNome(ultimoNome);
				utilizador.setNuc(nuc);
				utilizador.seteMail(email);

				// Criação do utilizador
				uH.editarUtilizador(utilizador);
				Utilizador uEditado = uH.getUtilizadorByEMail(email);

				session.setAttribute("utilizador", uEditado);

				request.setAttribute("message", "Informações atualizadas");

			} catch (IllegalArgumentException | IllegalAccessException ex) {
				throw new ServletException(ex);
			}

			// Redireciona para a página login
			dispatcher = request.getRequestDispatcher("views/BackOffice/BOEditarUtilizador.jsp");

		}

		dispatcher.forward(request, response);
	}

}
