package br.com.unialfa.nupes.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {

	private static Connection con = null;

	public static Connection GetConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// LEMBRAR DE ALTERAR A SENHA!
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nupes?useTimezone=true&serverTimezone=UTC", "root", "81919604");
			return con;
		} catch (Exception e) {
			System.out.println("Erro na conexão!" + e.getMessage());

		}
		return con;
	}
	public void fechaConexao() {
	try {
		con.close();
	} catch (Exception e) {
		System.out.println("Erro na conexão." + e.getMessage());
	}	
	}
}
