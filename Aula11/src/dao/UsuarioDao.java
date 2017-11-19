package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDao {
	private Connection con = Connectionfactory.getConnection();

	public void inserir(Usuario usuario) {

		String sql = "Insert Into usuario (username, senha) values (?,?)";
  
		try {
			PreparedStatement stm = con.prepareStatement(sql);

			stm.setString(1, usuario.getUsername());
			stm.setString(2, usuario.getSenha());

			stm.executeQuery();
			System.out.println("antes do close " );

			stm.close();

		} catch (Exception e) {
			System.out.println("Esta esta conectando " + e);

		}
	}

	public Usuario autenticacao(Usuario usuario) {
		// Objeto de retorno do método
		Usuario usu = null;

		String sql = "select * from usuario where username = ? and senha = ? ";
		ResultSet resultado;
		System.out.println("dento do usuario autentica " );


		try {
			PreparedStatement stm = con.prepareStatement(sql);

			stm.setString(1, usuario.getUsername());
			stm.setString(2, usuario.getSenha());
			// consulta ao resultSet
			resultado = stm.executeQuery();

			// verifica sem tem o registro

			if (resultado.next()) {

				usu = new Usuario();
				usu.setUsername(resultado.getString("username"));
				usu.setSenha(resultado.getString("senha"));

			}
			System.out.println("Encontrado com sucesso!");
		} catch (SQLException e) {

			System.out.println("Erro de SQL:" + e.getMessage());
		}
		return usu;
	}

}
