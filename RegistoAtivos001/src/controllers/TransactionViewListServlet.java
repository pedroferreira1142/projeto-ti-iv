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
 * Servlet implementation class TransactionViewListServlet
 */
@WebServlet("/TransactionViewListServlet")
public class TransactionViewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionViewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Instaciamentos:
		MovimentoHelper mH = new MovimentoHelper();
		ArtigoHelper aH = new ArtigoHelper();
		TipoMovimentoHelper tMH = new TipoMovimentoHelper();
				
		try 
		{
			//Listagens
			List<ItemLista> listaTipoMovimento = tMH.listarTipoMovimento();
			List<Artigo> listaArtigo = aH.listarArtigo();
			List<Movimento> listaMovimento = mH.listarMovimentoPorData();			
			
			// Atribuição das variaveis de passagem para a view:
			request.setAttribute("listaTipoMovimento", listaTipoMovimento);
			request.setAttribute("listaArtigo", listaArtigo);
			request.setAttribute("listaMovimento", listaMovimento);
			
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		// Redireciona para a listagem de conteúdo
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Movimento/ListarMovimento.jsp");
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
