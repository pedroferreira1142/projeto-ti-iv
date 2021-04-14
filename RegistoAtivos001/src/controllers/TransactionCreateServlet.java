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
 * Servlet implementation class TransactionCreateServlet
 */
@WebServlet("/TransactionCreateServlet")
public class TransactionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Instaciamentos:
		Artigo a = new Artigo();
		Movimento mov = new Movimento();
		MovimentoHelper mH = new MovimentoHelper(); 
		ArtigoHelper aH = new ArtigoHelper();
		TipoMovimentoHelper tMH = new TipoMovimentoHelper(); 
		Utilizador u = new Utilizador();
		UtilizadorHelper uH = new UtilizadorHelper();
		
		// Uid do artigo por parametro
		String uidArtigo = request.getParameter("uidArtigo");
		
		
		try 
		{
			// get o artigo por uid
			a = aH.getArtigo(uidArtigo);
			
			//Lista de tipos de movimento
			List<ItemLista> listaTipoMovimento = tMH.listarTipoMovimento();
			List<Movimento> listaMovimento = mH.listarMovimento(uidArtigo);
			List<Utilizador> listaUtilizador = uH.listarUtilizador(); 
			
			request.setAttribute("listaTipoMovimento", listaTipoMovimento);
			request.setAttribute("listaMovimento", listaMovimento);
			request.setAttribute("listaUtilizador", listaUtilizador);
			request.setAttribute("artigo", a);
			
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Movimento/CriarMovimento.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/views/Movimento/CriarMovimento.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Instaciamentos
		Movimento m = new Movimento();
		MovimentoHelper mH = new MovimentoHelper();
		Validator v = new Validator();
		ValidatorErrorMessages vEM = new ValidatorErrorMessages();
		
		
		// Parametros do form
		String uidUtilizador = request.getParameter("idUtilizador");
		String uidArtigo = request.getParameter("artigoUid");
		String localMovimento = request.getParameter("localMovimento");
		String colaboradorNuc = request.getParameter("colaboradorNuc");
		String nomeColaborador = request.getParameter("colaboradorNome");
		String tipoMovimento = request.getParameter("tipoMovimento");
		String obs = request.getParameter("obs");
		
		// Lista de campos
		List<String> campos = new ArrayList<String>();
		
		campos.add(uidUtilizador);
		campos.add(uidArtigo);
		campos.add(tipoMovimento);		
		
		if (v.checkFieldListAreNull(campos))
		{
			request.setAttribute("message", vEM.get_errorNotNull());
		}
		else
		{
			// Try Cacth da criação do movimento
			try
			{
				// Atribuição dos atributos do utilizador
				m.setUidUtilizador(uidUtilizador);
				m.setUidArtigo(uidArtigo);
				m.setLocalStock(localMovimento);
				m.setColaboradorNuc(colaboradorNuc);
				m.setNomeColaborador(nomeColaborador);
				m.setUidTipoMovimento(tipoMovimento);
				m.setObs(obs);
				
				// Criação do movimento
				mH.criarMovimento(m);
				
				// Mensagem de criação do movimento
				request.setAttribute("message", "Novo movimento criado");
			}
			catch (IllegalArgumentException ex ) 
			{
				throw new ServletException(ex);
			}
				
			// Redireciona para a listagem de conteúdo
			response.sendRedirect(request.getContextPath() + "/ItemViewServlet?idArtigo="+uidArtigo);
		}		
	}
}
