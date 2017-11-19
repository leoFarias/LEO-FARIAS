package model;

import dao.ConjuntoDao;

public class Conjunto {
	private int id;

	private String nome;
	private int andar;

	public Conjunto() {
		this(0, "Sem nome", 0);
	}

	public Conjunto(String nome, int andar) {
		this.setNome(nome);
		this.setAndar(andar);
	}

	public Conjunto(int id, String nome, int andar) {
		this.setId(id);
		this.setNome(nome);
		this.setAndar(andar);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getAndar() {
		return andar;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public void criar() {
		ConjuntoDao dao = new ConjuntoDao();
		dao.incluir(this);
	};

	public void alterar() {
		ConjuntoDao dao = new ConjuntoDao();
		dao.atualizar(this);
	}

	public void apagar() {
		ConjuntoDao dao = new ConjuntoDao();
		dao.excluir(this);
	}

	public Conjunto carregar() {
		ConjuntoDao dao = new ConjuntoDao();
		Conjunto conjunto = dao.carregar(this);
		return conjunto;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + andar;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conjunto other = (Conjunto) obj;
		if (andar != other.andar)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String toString() {
		return "Codigo: \t " + id + " \n Nome \t " + nome + " \n Andar \t" + andar;
	}
}
