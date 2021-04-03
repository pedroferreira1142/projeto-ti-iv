package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
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
 * Servlet implementation class ItemCreateServlet
 */
@WebServlet("/ItemCreateServlet")
public class ItemCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String e = "teste";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ItemCreateServlet() 
    {
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
		TipoArtigoHelper tAH = new TipoArtigoHelper();
		
		
		// Sess�o do utilizador
		HttpSession session = request.getSession();
		
		try
		{
			List<ItemLista> listaTeste = eH.listarEstado();
			request.setAttribute("listaEstados", listaTeste);
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		//response.sendRedirect("views/Artigo/CriarArtigo.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Artigo/CriarArtigo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Instaciamentos
		Validator v = new Validator();
		ValidatorErrorMessages vEM = new ValidatorErrorMessages(); 
		Artigo a = new Artigo();
		ArtigoHelper aH = new ArtigoHelper();
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();
		
		String descricao = request.getParameter("descricaoArtigo");
		String marca = request.getParameter("marcaArtigo");
		String modelo = request.getParameter("modelo");
		String numImobilizado = request.getParameter("numImobilizado");
		String numSerie = request.getParameter("numSerie");
		String localStock = request.getParameter("localStock");
		String obs = request.getParameter("obs");
		
		campos.add(descricao);
		campos.add(marca);
		campos.add(modelo);
		campos.add(numImobilizado);
		campos.add(numSerie);
		campos.add(localStock);
		
		// P�gina login
		String destPage = null;
		
		// Se existir algum campo obrigat�rio nulo
		if (v.checkFieldListAreNull(campos))
		{
			request.setAttribute("message", vEM.get_errorNotNull());
			destPage = "views/Utilizador/CriarUtilizador.jsp";
		}
		else
		{
			// Try Cacth da cria��o do utilizador
			try
			{
				// Atribui��o dos atributos do utilizador
				a.setDescricao(descricao);
				a.setMarca(marca);
				a.setModelo(modelo);
				a.setNumImobilizado(numImobilizado);
				a.setNumSerie(numSerie);
				a.setLocalStock(localStock);
				a.setObs(obs);
				
				// Cria��o do utilizador
				aH.criarArtigo(a);
				
				// Mensagem e p�gina index
				request.setAttribute("message", "Novo artigo criado");
				destPage = "views/Utilizador/index.jsp";
			}
			catch (IllegalArgumentException ex ) 
			{
				throw new ServletException(ex);
			}
				
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
		}
		
	}

}
