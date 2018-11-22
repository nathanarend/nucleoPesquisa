package br.com.unialfa.nupes.controller;

import java.awt.Window;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PrincipalController {

	@FXML
	private AnchorPane PanePrincipal;

	@FXML
	private AnchorPane PaneCadastro1;

	@FXML
	private JFXButton btnDeslogar, btnVoltar;

	@FXML
	private Button btnCadastro;

	@FXML
	private Button btnDocumentos;

	@FXML
	private Button btnRelatorio;

	@FXML
	private Button btnCadCurso, btnCadProfessor, btnDeclaracao;

//Stage
//	Scene
//	Titulo
//	mostra
	private static Stage stage;

	@FXML
	void cadAluno(ActionEvent event) throws IOException {
		if (stage == null) {
			stage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/FXMLCadastroAluno.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Cadastro Aluno.");
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					stage = null;
				}
			});

		}
	}

	@FXML
	void cadastrar(ActionEvent event) throws IOException {
		URL arquivoFXML;
		arquivoFXML = getClass().getResource("../view/FXMLCadastro.fxml");
		Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		PanePrincipal.getChildren().clear();
		PanePrincipal.getChildren().add(fxmlParent);
		// Scene scene = new Scene(fxmlParent, 774, 521);

	}

	@FXML
	void CadProfessor(ActionEvent event) throws IOException {

		if (stage == null) {
			stage = new Stage();

			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("../view/FXMLCadastroProfessor.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Cadastro Aluno.");
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {
					stage = null;
				}
			});
		}
	}

	@FXML
	void cadBanca(ActionEvent event) throws IOException {

		URL arquivoFXML;
		arquivoFXML = getClass().getResource("../view/FXMLCadastroBanca.fxml");
		Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		PaneCadastro1.getChildren().clear();
		PaneCadastro1.getChildren().add(fxmlParent);

	}

	@FXML
	void abreDoc(ActionEvent event) throws IOException {
		URL arquivoFXML;
		arquivoFXML = getClass().getResource("../view/FXMLGerarSalvarDoc.fxml");
		Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		PanePrincipal.getChildren().clear();
		PanePrincipal.getChildren().add(fxmlParent);
	}

	@FXML
	void abreRelatorio(ActionEvent event) throws IOException {
		JOptionPane.showMessageDialog(null, "EM BREVE!");
	}

	@FXML
	void voltar(ActionEvent event) throws IOException {
		URL arquivoFXML;
		arquivoFXML = getClass().getResource("../view/FXMLPrincipal.fxml");
		Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		PaneCadastro1.getChildren().clear();
		PaneCadastro1.getChildren().add(fxmlParent);
	}

	@FXML
	void retornaLogin(ActionEvent event) throws IOException {
		URL arquivoFXML;
		arquivoFXML = getClass().getResource("../view/FXMLLogin.fxml");
		Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		PanePrincipal.getChildren().clear();
		PanePrincipal.getChildren().add(fxmlParent);
	}

}
