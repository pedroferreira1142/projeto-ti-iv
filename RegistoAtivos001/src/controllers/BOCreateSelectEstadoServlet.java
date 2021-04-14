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

import models.*;

/**
 * Servlet implementation class BOCreateSelectEstadoServlet
 */
@WebServlet("/BOCreateSelectEstadoServlet")
public class BOCreateSelectEstadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOCreateSelectEstadoServlet() {
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
		ItemLista estadoCriado = new ItemLista();
		EstadoHelper eH = new EstadoHelper();
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();
		
		// Recebe os dados dos campos do formulário
		String item = request.getParameter("item");
		
		campos.add(item);
		
		// Se existir algum campo obrigatório nulo
		if (v.checkFieldListAreNull(campos))
		{
			// Redireciona para a listagem de conteúdo
			response.sendRedirect(request.getContextPath() + "/BOSelectListEditorServlet");
		}
		else
		{
			// Try Cacth da criação do utilizador
			try
			{
				// Atribuição dos atributos do utilizador
				estadoCriado.setItem(item);
				
				// Criação do utilizador
				eH.criarEstado(estadoCriado);
				
				// Mensagem e página index
				request.setAttribute("message", "Novo estado criado");
			}
			catch (IllegalArgumentException ex ) 
			{
				throw new ServletException(ex);
			}
				
			
			// Redireciona para a listagem de conteúdo
			response.sendRedirect(request.getContextPath() + "/BOSelectListEditorServlet");
		}
		
		
	}

}
