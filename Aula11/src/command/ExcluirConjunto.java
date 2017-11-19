package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conjunto;
import service.ConjuntoService;



public class ExcluirConjunto implements Command {

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

		cs.excluir(conjunto.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Conjunto> lista = (ArrayList<Conjunto>) session
				.getAttribute("lista");
		lista.remove(busca(conjunto, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarConjunto.jsp");
		view.forward(request, response);

	}

	public int busca(Conjunto conjunto, ArrayList<Conjunto> lista) {
		Cliente to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == cliente.getId()){
				return i;
			}
		}
		return -1;
	}

}
