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
import javax.servlet.http.HttpSession;

import models.*;

/**
 * Servlet implementation class ItemViewServlet
 */
@WebServlet("/ItemViewServlet")
public class ItemViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Utilizador
		HttpSession session = request.getSession();
		Utilizador u = (Utilizador) session.getAttribute("user");
		
		// Instaciamentos
		EstadoHelper eH = new EstadoHelper();
		TipoArtigoHelper tAH = new TipoArtigoHelper();
		Artigo a = new Artigo();
		ArtigoHelper aH = new ArtigoHelper();
		Movimento mov = new Movimento();
		MovimentoHelper mH = new MovimentoHelper(); 
		TipoMovimentoHelper tMH = new TipoMovimentoHelper(); 
		UtilizadorHelper uH = new UtilizadorHelper();
		
		try
		{
			// Pedido do atributo com o Uid do artigo
			String uidArtigo = request.getParameter("idArtigo");
			
			// Artigo por uid
			a = aH.getArtigo(uidArtigo);
			
			// Listagem de estados e tipo de artigo
			List<ItemLista> listaEstados = eH.listarEstado();
			List<ItemLista> listaTipoArtigo = tAH.listarTipoArtigo();
			//Lista de tipos de movimento
			List<ItemLista> listaTipoMovimento = tMH.listarTipoMovimento();
			List<Movimento> listaMovimento = mH.listarMovimento(uidArtigo);
			List<Utilizador> listaUtilizador = uH.listarUtilizador(); 
			
			
			// Estado e tipo do artigo
			ItemLista estadoArtigo = eH.getEstado(a.getFkIdEstado());
			ItemLista tipoArtigo = tAH.getTipoArtigo(a.getFkIdTipoArtigo());
			//Atribuição dos atributos para o request
			request.setAttribute("estadoArtigo", estadoArtigo);
			request.setAttribute("tipoArtigo", tipoArtigo);
			request.setAttribute("artigoByUid", a);
			request.setAttribute("listaEstados", listaEstados);
			request.setAttribute("listaTipoArtigos", listaTipoArtigo);
			request.setAttribute("listaTipoMovimento", listaTipoMovimento);
			request.setAttribute("listaMovimento", listaMovimento);
			request.setAttribute("listaUtilizador", listaUtilizador);
			request.setAttribute("artigo", a);
		}
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Artigo/VerArtigo.jsp");
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
		
		// Values dos campos do form
		String uid = request.getParameter("uid");
		String descricao = request.getParameter("descricaoArtigo");
		String marca = request.getParameter("marcaArtigo");
		String modelo = request.getParameter("modelo");
		String numImobilizado = request.getParameter("numImobilizado");
		String numSerie = request.getParameter("numSerie");
		String localStock = request.getParameter("localStock");
		String obs = request.getParameter("obs");
		String estado = request.getParameter("estado");
		String tipoArtigo = request.getParameter("tipoArtigo");
		
		campos.add(descricao);
		campos.add(marca);
		campos.add(modelo);
		campos.add(numImobilizado);
		campos.add(numSerie);
		campos.add(localStock);
		
		// Página login
		String destPage = null;
		
		// Se existir algum campo obrigatório nulo
		if (v.checkFieldListAreNull(campos))
		{
			request.setAttribute("message", vEM.get_errorNotNull());
			destPage = "views/Artigo/VerArtigo.jsp";
		}
		else
		{
			// Try Cacth da criação do utilizador
			try
			{
				// Atribuição dos atributos do utilizador
				a.setUid(uid);
				a.setDescricao(descricao);
				a.setMarca(marca);
				a.setModelo(modelo);
				a.setNumImobilizado(numImobilizado);
				a.setNumSerie(numSerie);
				a.setLocalStock(localStock);
				a.setObs(obs);
				a.setFkIdEstado(estado);
				a.setFkIdTipoArtigo(tipoArtigo);
				
				// Criação do utilizador
				aH.editarArtigo(a);
				
				// Mensagem e página do artigo
				request.setAttribute("message", "Artigo atualizado");
				destPage = "views/Artigo/VerArtigo.jsp";
			}
			catch (IllegalArgumentException | IllegalAccessException ex ) 
			{
				throw new ServletException(ex);
			}
				
			response.sendRedirect(request.getContextPath() + "/ItemViewServlet?idArtigo="+uid);
			//RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			//dispatcher.forward(request, response);
		}
		
	}

}
