package br.com.unialfa.nupes.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.exception.CamposInvalidosException;
import br.com.unialfa.nupes.exception.RegraDeNegocioException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LoginController {
	@FXML
	private JFXPasswordField txtSenha;

	@FXML
	private ImageView imgSenha;

	@FXML
	private ImageView imgUnialfa;

	@FXML
	private ImageView imgusuario;

	@FXML
	private JFXTextField txtUsuario;

	@FXML
	private JFXButton btnEntrar;
	@FXML
	private AnchorPane paneLogin;
	
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;

	@FXML
	void logar() throws CamposInvalidosException{
		String sql = "SELECT senha,login FROM usuario WHERE senha=? AND login=?";
		try {
			con = ModuloConexao.GetConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtSenha.getText());
			rs = pst.executeQuery();
			verificaCampos();
			if (rs.next()) {
				
				AbrePrincipal();
			}else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou Senha INVÁLIDOS");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void AbrePrincipal() throws IOException{
		URL arquivoFXML;
		arquivoFXML = getClass().getResource("../view/FXMLPrincipal.fxml");
		Parent  fxmlParent = (Parent)FXMLLoader.load(arquivoFXML);
		paneLogin.getChildren().clear();
		paneLogin.getChildren().add(fxmlParent);
	}

	private void verificaCampos() throws CamposInvalidosException{
	if(txtUsuario.getText().equals("") || txtUsuario.getText() == null	||txtUsuario.getText().isEmpty()) {
		throw new CamposInvalidosException();
	}
	
	}
}
