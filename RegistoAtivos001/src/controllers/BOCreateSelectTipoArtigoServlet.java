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
 * Servlet implementation class BOCreateSelectTipoArtigoServlet
 */
@WebServlet("/BOCreateSelectTipoArtigoServlet")
public class BOCreateSelectTipoArtigoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOCreateSelectTipoArtigoServlet() {
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
		// Instaciamentos
		Validator v = new Validator();
		ValidatorErrorMessages vEM = new ValidatorErrorMessages();
		ItemLista tipoArtigoCriado = new ItemLista();
		TipoArtigoHelper tAH = new TipoArtigoHelper();
		
		// Recebe os dados dos campos do formulário
		String item = request.getParameter("item");
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();
		campos.add(item);
		
		// Se existir algum campo obrigatório nulo
		if (v.checkFieldListAreNull(campos))
		{
			// Mensagem de erro
			request.setAttribute("message", vEM.get_errorNotNull());
		}
		else
		{
			// Try Cacth da criação do utilizador
			try
			{
				// Atribuição dos atributos do utilizador
				tipoArtigoCriado.setItem(item);
				
				// Criação do utilizador
				tAH.criarTipoArtigo(tipoArtigoCriado);
				
				// Mensagem e página index
				request.setAttribute("message", "Novo tipo de artigo criado");
			}
			catch (IllegalArgumentException ex ) 
			{
				throw new ServletException(ex);
			}
		}
		// Redireciona para a listagem de conteúdo
		response.sendRedirect(request.getContextPath() + "/BOSelectListEditorServlet");
	}

}
