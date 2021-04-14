package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.*;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instaciamentos:
		ArtigoHelper aH = new ArtigoHelper();
		MovimentoHelper mH = new MovimentoHelper();
		UtilizadorHelper uH = new UtilizadorHelper();
		
		try
		{
			int countRegistosArtigo = aH.contarArtigo();
			int countRegistosMovimento = mH.contarMovimento();
			int countRegistosUtilizador = uH.contarUtilizador();
			
			List<Artigo> listaArtigosRecentes = aH.listarArtigoRecentes();
			List<Movimento> listaMovimentoRecentes = mH.listarMovimentoRecentes();
			
			request.setAttribute("countRegistosArtigo", countRegistosArtigo);
			request.setAttribute("countRegistosMovimento", countRegistosMovimento);
			request.setAttribute("countRegistosUtilizador", countRegistosUtilizador);
			
			request.setAttribute("listaArtigosRecentes", listaArtigosRecentes);
			request.setAttribute("listaMovimentoRecentes", listaMovimentoRecentes);
			
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
