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
 * Servlet implementation class BOEditSelectEstadoServlet
 */
@WebServlet("/BOEditSelectEstadoServlet")
public class BOEditSelectEstadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOEditSelectEstadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instaciamentos
		Validator v = new Validator();
		ItemLista estadoEditado = new ItemLista();
		EstadoHelper eH = new EstadoHelper();
		ValidatorErrorMessages vE = new ValidatorErrorMessages();
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();
		
		// Recebe os dados dos campos do formulário
		String uid = request.getParameter("uid");
		String item = request.getParameter("item");
		
		campos.add(item);
		
		// Se existir algum campo obrigatório nulo
		if (v.checkFieldListAreNull(campos))
		{
			// Mensagem de erro
			request.setAttribute("messageFieldNull", vE.get_errorNotNull());
		}
		else
		{
			// Try Cacth da criação do utilizador
			try
			{
				// Atribuição dos atributos do utilizador
				estadoEditado.setUid(uid);
				estadoEditado.setItem(item);
				
				// Criação do utilizador
				eH.editarEstado(estadoEditado);
				
				// Mensagem e página index
				request.setAttribute("message", "Item editado");
			}
			catch (IllegalArgumentException | IllegalAccessException ex ) 
			{
				throw new ServletException(ex);
			}
				
		}
		// Redireciona para a listagem de conteúdo
		response.sendRedirect(request.getContextPath() + "/BOSelectListEditorServlet");
	}

}
