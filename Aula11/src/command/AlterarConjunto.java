package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conjunto;



public class AlterarConjunto implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pAndar = request.getParameter("andar");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
         Conjunto conjunto  = new Conjunto();
         conjunto.setId(id);
         conjunto.setNome(pNome);
         conjunto.setAndar(pAndar);
		 ConjuntoService cs = new ConjuntoService();
		 
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		cs.atualizar(conjunto);
		@SuppressWarnings("unchecked")
		ArrayList<Conjunto> lista = (ArrayList<Conjunto>) session
				.getAttribute("lista");
		int pos = busca(conjunto, lista);
		lista.remove(pos);
		lista.add(pos, conjunto);
		session.setAttribute("lista", lista);
		request.setAttribute("conjunto", conjunto);
		view = request.getRequestDispatcher("VisualizarConjunto.jsp");

		view.forward(request, response);

	}

	public int busca(Conjunto conjunto , ArrayList<Conjunto> lista) {
		Conjunto to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == conjunto.getId()) {
				return i;
			}
		}
		return -1;
	}

}
