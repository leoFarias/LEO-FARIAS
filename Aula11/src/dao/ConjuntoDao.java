package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Conjunto;

// @author Leonardo
public class ConjuntoDao {

	public boolean incluir(Conjunto conjunto) {
		Connection con = Connectionfactory.getConnection();
		PreparedStatement stm = null;

		try {

			stm = con.prepareStatement("INSERT INTO conjunto( id, nome,andar)VALUES(?,?,?)");

			
			stm.setInt(1, conjunto.getId());
			stm.setString(2, conjunto.getNome());
			stm.setInt(3, conjunto.getAndar());
			stm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(ConjuntoDao.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showInputDialog(null, "erro ao criar" + ex);
		} finally {
			Connectionfactory.fechaConection(con, stm);
		}
		return true;
	}

	public boolean atualizar(Conjunto conjunto) {

		Connection con = Connectionfactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("UPDATE conjunto SET nome=?, andar=? WHERE id= ? ");

			stm.setString(1, conjunto.getNome());
			stm.setInt(2, conjunto.getAndar());
			stm.setInt(3, conjunto.getId());
			stm.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(ConjuntoDao.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "erro ao atualizar" + ex);

		} finally {
			Connectionfactory.fechaConection(con, stm);
		}
		return true;
	}

	public boolean excluir(Conjunto conjunto) {
		Connection con = Connectionfactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE FROM  conjunto WHERE id = ?");

			stm.setInt(1, conjunto.getId());
			JOptionPane.showMessageDialog(null, "excluido  com sucesso!!! " + conjunto.toString());

			stm.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(ConjuntoDao.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, ex + "erro ao excluir");

		} finally {
			Connectionfactory.fechaConection(con, stm);
		}
		return true;

	}

	public Conjunto carregar(Conjunto conjunto) {

		Connection con = Connectionfactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT nome, andar FROM conjunto WHERE id = ?");
			System.out.println(conjunto);
			System.out.println(conjunto.getId());
			System.out.println(stm);
			stm.setInt(1, conjunto.getId());

			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				conjunto.setNome(rs.getString("nome"));
				conjunto.setAndar(rs.getInt("andar"));

			}
		} catch (SQLException ex) {
			Logger.getLogger(ConjuntoDao.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showInputDialog(ex, "erro ao carregar");
		} finally {

			Connectionfactory.fechaConection(con, stm);
		}
		return conjunto;

	}

}
