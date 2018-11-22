package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.unialfa.nupes.configuration.ModuloConexao;

import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.entity.Pessoa;
import br.com.unialfa.nupes.entity.Professor;
import br.com.unialfa.nupes.enumerator.EnumGrauAcademico;

public class ProfessorDAO implements DAOInterface<Professor, Curso> {
	EnumGrauAcademico eg;

	private final String sql = "INSERT INTO professor(nome,matricula,sexo,titulacao) VALUES (?,?,?,?)";

	@Override
	public void salvar(Professor p, Curso curso) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();
		Pessoa pessoa = new Pessoa();

		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);

			String titulo = p.getEnumGrauAcademico().getGrau();
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getMatricula());
			String s = p.getEnumSexo().getSexo();
			stmt.setString(3, s);
			String t = p.getEnumGrauAcademico().getGrau();
			stmt.setString(4, t);

			stmt.executeUpdate();
			conn.commit();
			JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO!");
			System.out.println("Salvo");
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("ops");
			e.printStackTrace();
		}

	}

}
