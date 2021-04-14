package controllers;

import java.io.IOException;
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
 * Servlet implementation class BOSelectListEditorServlet
 */
@WebServlet("/BOSelectListEditorServlet")
public class BOSelectListEditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOSelectListEditorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Instaciamentos
		EstadoHelper eH = new EstadoHelper();
		TipoMovimentoHelper tMH = new TipoMovimentoHelper();
		TipoArtigoHelper tAH = new TipoArtigoHelper();
		
		
		try
		{
			// Listas de Items
			List<ItemLista> listaTipoArtigo = tAH.listarTipoArtigo();
			List<ItemLista> listaTipoMovimento = tMH.listarTipoMovimento();
			List<ItemLista> listaEstado = eH.listarEstado();
			
			// Atribuição dos atributos do request
			request.setAttribute("listaEstado", listaEstado);
			request.setAttribute("listaTipoMovimento", listaTipoMovimento);
			request.setAttribute("listaTipoArtigo", listaTipoArtigo);
			
		}
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		
		
		// Faz request da página
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/BackOffice/BOListarConteudo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
