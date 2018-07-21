package testeJsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import testeJsp.modelo.Casa;

/**
 * Servlet implementation class CasaServlet
 */
@WebServlet("/casaServlet")
public class CasaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String destino="casa.jsp";

		double valor= Double.parseDouble(request.getParameter("valor"));
		String nome= request.getParameter("nome");
		
		try {
		Casa casa1= new Casa();
		casa1.setNome(nome);
		casa1.setValor(valor);
		casa1.descontoCasa();
			
		request.setAttribute("casa1", casa1);
		request.setAttribute("mensa", "Deu certo");

		}catch(Exception ex){
			request.setAttribute("mensa", "Deu merda!!!");

		}
		dispatcher= request.getRequestDispatcher(destino);
		dispatcher.forward(request, response);
		
		
	}

	

}
