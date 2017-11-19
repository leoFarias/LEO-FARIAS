package teste;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import dao.ConjuntoDao;
import model.Conjunto;

public class ConjuntoTes {
	ConjuntoDao dao;
	Conjunto conjunto, copia;
	static int id = 81;

	@Before
	public void setUp() throws Exception {

		conjunto = new Conjunto(id, "Francisco", 2);
		copia = new Conjunto(99, "Guilherme", 3);

	}

	@Test

	public void inserir() {
		dao = new ConjuntoDao();
		if (dao.incluir(conjunto)) {
			id = conjunto.getId();
			copia.setId(id);

		} else {
			fail("Não esta Incluindo!!!");
		}
		Assert.assertEquals("Esta incluido", conjunto.getId(), copia.getId());
	}

	@Test
	public void apagar() {
    
	    Conjunto con = new Conjunto(6, "JavaTeste", 3);
		ConjuntoDao dao = new ConjuntoDao();
      
		if (dao.excluir(con)) {
			System.out.println("Excluido com sucesso !!!");

		} else {
			fail("erro não está exluindo");
		}

	}

	@Test
	public void consultar() {
		dao = new ConjuntoDao();
		Conjunto novo = new Conjunto(39, "JavaTeste", 3);

		if (dao.incluir(novo)) {
			copia.setId(novo.getId());
			copia.setNome(novo.getNome());
			copia.setAndar(novo.getAndar());
			dao.carregar(novo);

		} else {
			fail("Não esta Consultando!!!");
		}
		Assert.assertEquals("Esta Consultando", novo, copia);
	}

	@Test

	public void alterar() {
		dao = new ConjuntoDao();
		Conjunto con = new Conjunto(12, "Jose", 6);

		if (dao.incluir(con)) {
			copia.setId(12);
			copia.setNome("GuilhermeX");
			copia.setAndar(4);
			con.setNome(copia.getNome());
			con.setAndar(copia.getAndar());
			dao.atualizar(con);
		}

		else {
			fail("Não esta apagando!!!");
		}
		Assert.assertEquals("Esta Excluido", con, copia);
	}

}
