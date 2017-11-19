package service;

import dao.ConjuntoDao;
import model.Conjunto;

public class ConjuntoService {
	ConjuntoDao dao;

	public ConjuntoService() {
		dao = new ConjuntoDao();
	}

	public void salvar(Conjunto conjunto) {
		dao.incluir(conjunto);

	}

	public void alterar(Conjunto conjunto) {
		dao.atualizar(conjunto);
	}
	
	

	public void apagar(Conjunto conjunto) {

		dao.excluir(conjunto);
	}

	public Conjunto consultar(Conjunto conjunto) {
		return dao.carregar(conjunto);
	}

}
