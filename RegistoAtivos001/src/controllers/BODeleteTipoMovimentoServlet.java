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
 * Servlet implementation class BODeleteTipoMovimentoServlet
 */
@WebServlet("/BODeleteTipoMovimentoServlet")
public class BODeleteTipoMovimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BODeleteTipoMovimentoServlet() {
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
		TipoMovimentoHelper tMH = new TipoMovimentoHelper();
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();
		
		// Recebe os dados dos campos do formul�rio
		String idTipoMovimento = request.getParameter("idTipoMovimento");
		
		campos.add(idTipoMovimento);
		
		// Se existir algum campo obrigat�rio nulo
		if (v.checkFieldListAreNull(campos))
		{
			// Mensagem de erro
			request.setAttribute("message", "Item n�o v�lido");
		}
		else
		{
			// Try Cacth da cria��o do utilizador
			try
			{				
				// Apagar Estado
				tMH.apagarTipoMovimento(idTipoMovimento);
				
				// Mensagem e p�gina index
				request.setAttribute("message", "Tipo de movimento apagado");
			}
			catch (IllegalArgumentException | IllegalAccessException ex ) 
			{
				throw new ServletException(ex);
			}
				
			
			// Redireciona para a listagem de conte�do
			response.sendRedirect(request.getContextPath() + "/BOSelectListEditorServlet");
		}
	}

}
