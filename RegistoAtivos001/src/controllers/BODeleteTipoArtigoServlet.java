package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.*;

/**
 * Servlet implementation class BODeleteTipoArtigoServlet
 */
@WebServlet("/BODeleteTipoArtigoServlet")
public class BODeleteTipoArtigoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BODeleteTipoArtigoServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instaciamentos
		Validator v = new Validator();
		TipoArtigoHelper tAH = new TipoArtigoHelper();
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();
		
		// Recebe os dados dos campos do formulário
		String idTipoArtigo = request.getParameter("idTipoArtigo");
		
		campos.add(idTipoArtigo);
		
		// Se existir algum campo obrigatório nulo
		if (v.checkFieldListAreNull(campos))
		{
			// Mensagem de erro
			request.setAttribute("message", "Item não válido");
		}
		else
		{
			// Try Cacth da criação do utilizador
			try
			{				
				// Apagar Estado
				tAH.apagarTipoArtigo(idTipoArtigo);
				
				// Mensagem e página index
				request.setAttribute("message", "Tipo de Artigo apagado");
			}
			catch (IllegalArgumentException | IllegalAccessException ex ) 
			{
				throw new ServletException(ex);
			}
				
			
			// Redireciona para a listagem de conteúdo
			response.sendRedirect(request.getContextPath() + "/BOSelectListEditorServlet");
		}
	}

}
