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
import models.UtilizadorHelper;
import models.Validator;
import models.ValidatorErrorMessages;

/**
 * Servlet implementation class BOEditUserPremissionServlet
 */
@WebServlet("/BOEditUserPremissionServlet")
public class BOEditUserPremissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOEditUserPremissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Sessão do utilizador
		HttpSession session = request.getSession();

		// Instanciamentos
		UtilizadorHelper uH = new UtilizadorHelper();
		Utilizador u = new Utilizador();
		
		// Valores dos campos submtidos
		int tipoConta =  Integer.parseInt(request.getParameter("tipoConta"));
		String eMail = request.getParameter("utilizadorEMail");
		
		try 
		{
			// TODO inserir verificador de e-mail
			// Extrai o utilizador por e-mail
			u = uH.getUtilizadorByEMail(eMail);
			
			// Verifica se é um inteiro
			if (tipoConta == (int)tipoConta)
				uH.editarTipoUtilizador(eMail, tipoConta);
			request.setAttribute("utilizador", u);
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		// Redireciona para de edição do utilizador (Backoffice)
		response.sendRedirect(request.getContextPath() + "/BOUserEditServlet?eMailUtilizador="+eMail);
	}

}
