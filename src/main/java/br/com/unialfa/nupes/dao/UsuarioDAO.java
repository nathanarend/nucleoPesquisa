package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
//CLASSE NO QUAL IRÁ SALVAR O USUARIO NO BANCO. **********TELA AINDA NÃO IMPLEMENTADA.***************
//Ps: Thiago.

import br.com.unialfa.nupes.configuration.ModuloConexao;

public class UsuarioDAO {
	private ModuloConexao connection = null;
	private Connection con;
	private Statement stmt = null;
	private PreparedStatement pst = null;

	public UsuarioDAO() {
		ModuloConexao Mc = new ModuloConexao();
		con = Mc.GetConnection();
	}

}
