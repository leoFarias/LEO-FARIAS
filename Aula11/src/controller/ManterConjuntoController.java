package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import model.Conjunto;
import service.ConjuntoService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterConjunto.do")
public class ManterConjuntoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cNome = request.getParameter("nome");
		String cAndar = request.getParameter("andar");
		int id = Integer.parseInt(request.getParameter("identificador"));
		String pegar = request.getParameter("ação");
		//instanciar o javabean
		
				
		Conjunto conjunto = new Conjunto();
		conjunto.setNome(cNome);
		conjunto.setAndar(Integer.parseInt(cAndar));
		conjunto.setId(id);

		//instanciar o service
		ConjuntoService s = new ConjuntoService();
		System.out.println("ação pegada \t " + pegar);
		
		if(pegar.contains("ação") || pegar.equals("Inserir")){
		
			s.salvar(conjunto);
		conjunto = s.consultar(conjunto);
		 System.out.println("vai entra no JSP");
		 
		request.setAttribute("conjunto",conjunto);
		RequestDispatcher vws = request.getRequestDispatcher("Conjunto.jsp");
		vws.forward(request, response);
		
		
		
	}else if(pegar.contains("ação") || pegar.equals("Apagar")){

		
		System.out.println("entrou no apagar" );
        
		s.apagar(conjunto);
		conjunto = s.consultar(conjunto);
        
        
        
        request.setAttribute("conjunto",conjunto);
		RequestDispatcher vws = request.getRequestDispatcher("Conjunto.jsp");
		vws.forward(request, response);
		
        
        
		
		
	}else if (pegar.contains("ação") || pegar.equals("Consultar")){
		  s.consultar(conjunto);
		    
		  conjunto = s.consultar(conjunto);
 	  System.out.println(conjunto + " \t Aqui os dados do conjunto");
		  
		    request.setAttribute("conjunto",conjunto);
			RequestDispatcher vws = request.getRequestDispatcher("Conjunto.jsp");
			vws.forward(request, response);
	
		
	}else {
		s.alterar(conjunto);
		conjunto = s.consultar(conjunto);
		
		request.setAttribute("conjunto",conjunto);
		RequestDispatcher vws = request.getRequestDispatcher("Conjunto.jsp");
		vws.forward(request, response);
	}
 }
}
