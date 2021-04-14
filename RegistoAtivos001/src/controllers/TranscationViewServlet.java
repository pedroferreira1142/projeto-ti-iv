package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.*;

/**
 * Servlet implementation class TranscationViewServlet
 */
@WebServlet("/TransactionViewServlet")
public class TranscationViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TranscationViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Instaciamentos:
		Movimento m = new Movimento();
		UtilizadorHelper uH = new UtilizadorHelper();
		MovimentoHelper mH = new MovimentoHelper();
		ArtigoHelper aH = new ArtigoHelper();
		TipoMovimentoHelper tMH = new TipoMovimentoHelper();
		
		// uid do Movimento
		String uidMovimento = request.getParameter("idMovimento");
		
		try 
		{
			// Retirar o movimento por uid
			m = mH.getMovimento(uidMovimento);
			
			// Nome do artigo
			String artigoMovimento = aH.getArtigo(m.getUidArtigo()).getDescricao();
			// Nome do utilizador que criou
			String utilizadorMovimento = uH.getUtilizador(m.getUidUtilizador()).getPrimeiroNome() + " " +
					uH.getUtilizador(m.getUidUtilizador()).getUltimoNome();
			// Tipo de movimento
			String tipoMovimento = tMH.getTipoMovimento(m.getUidTipoMovimento()).getItem();
			
			// Atribuição das variaveis de passagem para a view:
			request.setAttribute("movimento", m);
			request.setAttribute("tipoMovimento", tipoMovimento);
			request.setAttribute("artigoMovimento", artigoMovimento);
			request.setAttribute("utilizadorMovimento", utilizadorMovimento);
			
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		// Redirecionamento
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Movimento/VerMovimento.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
