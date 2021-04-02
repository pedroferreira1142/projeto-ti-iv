package controllers;

import java.io.IOException;
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
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
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
		// Sessão
		HttpSession session = request.getSession();
		
		// Instaciamento
		Utilizador utilizador = (Utilizador) session.getAttribute("user");
		UtilizadorHelper uH = new UtilizadorHelper();
		
		// Página de perfil
		String destPage = "WEB-INF/views/Utilizador/login.jsp";;
		
		// Verifica a vericidade do UID
		if (utilizador.getUid() != "00000000-0000-0000-0000-000000000000")
		{
			uH.apagarUtilizador(utilizador.getUid());
			request.setAttribute("message", "Utilizador Apagado");
		}
		else
		{
			request.setAttribute("message", "Utilizador Inválido");
			destPage = "WEB-INF/views/Utilizador/VerUtilizador.jsp";
		}		
		
		// Redirecionamento
		RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
		dispatcher.forward(request, response);
		
		
		
		
		
	}

}
