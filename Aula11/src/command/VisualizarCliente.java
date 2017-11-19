package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conjunto;
import service.ConjuntoService;

public class VisualizarCliente implements Command {

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

		cliente = cs.carregar(cliente.getId());
		request.setAttribute("conjunto", conjunto);
		view = request.getRequestDispatcher("VisualizarConjunto.jsp");

		view.forward(request, response);

	}

}
