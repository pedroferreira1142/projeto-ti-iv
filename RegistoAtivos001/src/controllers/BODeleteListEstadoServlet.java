package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.EstadoHelper;
import models.ItemLista;
import models.Validator;

/**
 * Servlet implementation class BODeleteListEstadoServlet
 */
@WebServlet("/BODeleteListEstadoServlet")
public class BODeleteListEstadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BODeleteListEstadoServlet() {
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
		EstadoHelper eH = new EstadoHelper();
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();
		
		// Recebe os dados dos campos do formulário
		String idEstado = request.getParameter("idEstado");
		
		campos.add(idEstado);
		
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
				eH.apagarEstado(idEstado);
				
				// Mensagem e página index
				request.setAttribute("message", "Estado apagado");
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
