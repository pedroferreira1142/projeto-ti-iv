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
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/ItemSearchListServlet")
public class ItemSearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemSearchListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Instaciamentos
		EstadoHelper eH = new EstadoHelper();
		TipoArtigoHelper tAH = new TipoArtigoHelper();
		Artigo a = new Artigo();
		ArtigoHelper aH = new ArtigoHelper();

		// Recebe o valor pesquisado
		String stringPesquisa = request.getParameter("stringPesquisa");

		try {

			// Listagem da pesquisa dos artigos
			List<Artigo> listaPesquisaArtigos = aH.pesquisarArtigo(stringPesquisa);
			// Listagem dos selects
			List<ItemLista> listaEstados = eH.listarEstado();
			List<ItemLista> listaTipoArtigo = tAH.listarTipoArtigo();
			// Listagens
			request.setAttribute("listaPesquisaArtigos", listaPesquisaArtigos);
			request.setAttribute("listaEstados", listaEstados);
			request.setAttribute("listaTipoArtigos", listaTipoArtigo);
			// String de pesquisa
			request.setAttribute("stringPesquisa", stringPesquisa);
			

		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Artigo/ListarArtigo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
