package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.controller.CadastroBancaController;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Banca;
import br.com.unialfa.nupes.entity.Professor;

public class BancaDAO {
	static private int id;
	static Aluno a = new Aluno();
	static List<Aluno> nome = new ArrayList<>();

	public List<Aluno> listaAluno() throws SQLException {
		List<Aluno> listaAluno = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();

		try {

			String sql = "SELECT *  FROM aluno";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setId(rs.getInt("id_aluno"));
				listaAluno.add(aluno);
				nome.addAll(listaAluno);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAluno;

	}

	public void vinculaBanca(List<Aluno> ids, List<Professor> idP) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();
		for (Aluno a : ids) {
			String sql = "UPDATE aluno SET id_banca=? WHERE id_aluno = " + a.getId() + ";";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();

		}
		for (Professor p : idP) {
			String sql = "UPDATE professor SET id_banca=? WHERE id_professor = " + p.getId() + ";";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}

	}

	public List<Professor> listaprofessor() throws SQLException {
		List<Professor> professores = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();
		try {
			String sql = "SELECT * FROM professor";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setNome(rs.getString("nome"));
				professor.setId(rs.getInt("id_professor"));
				professores.add(professor);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professores;

	}

	public void save(Banca b) throws SQLException {

		String sql = "INSERT INTO banca(nome,dia) VALUES (?,?)";

		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();
		try {
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, b.getNome());
			stmt.setDate(2, b.getData());
			stmt.executeUpdate();

			ResultSet rs1 = stmt.getGeneratedKeys();
			rs1.next();
			id = rs1.getInt(1);

			// int rows = stmt.executeUpdate();

			conn.commit();
			System.out.println("Salvo com sucesso!");
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
