package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.entity.Aluno;

import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.enumerator.EnumCurso;

public class AlunoDAO implements DAOInterface<Aluno, Curso> {
	EnumCurso ec;
	Curso curs = new Curso();

	private final String salvar1 = "INSERT INTO aluno(nome,matricula,sexo,id_curso) VALUES (?,?,?,?)";

	private final String salvar2 = "INSERT INTO curso(nome) VALUES (?)";

	public void salvar(Aluno aluno, Curso curso) throws SQLException {
		// Aluno aluno = new Aluno();
		// AlunoOuProfessor ap = new AlunoOuProfessor();
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();

		try {
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(salvar2, Statement.RETURN_GENERATED_KEYS);

			String c = curso.getCurso().getNomeCurso();
			stmt.setString(1, c);
			int rows = stmt.executeUpdate();

			ResultSet rs1 = stmt.getGeneratedKeys();
			rs1.next();
			int idgerado = rs1.getInt(1);

			stmt = conn.prepareStatement(salvar1);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			String s = aluno.getEnumSexo().getSexo();
			stmt.setString(3, s);
			stmt.setInt(4, idgerado);



			stmt.executeUpdate();
			conn.commit();
			JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO!");
			System.out.println("Salvo com sucesso!");
			stmt.close();
			conn.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "MATRÍCULA JÁ CADASTRADA", "ERRO", JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
