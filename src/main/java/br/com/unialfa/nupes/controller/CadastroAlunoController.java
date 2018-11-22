package br.com.unialfa.nupes.controller;

import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.dao.AlunoDAO;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.enumerator.EnumCurso;
import br.com.unialfa.nupes.enumerator.EnumSexo;
import br.com.unialfa.nupes.exception.AlunoCadastroExceptionNome;
import br.com.unialfa.nupes.exception.CampoMatriculaException;
import br.com.unialfa.nupes.exception.SexoNuloException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadastroAlunoController implements Initializable {
	@FXML
	private JFXTextField txtNome;

	@FXML
	private JFXButton btnSalvar;

	@FXML
	private JFXButton btnCancelar;

	@FXML
	private JFXTextField txtMatricula;
	@FXML
	private JFXComboBox<EnumCurso> cbCurso;
	@FXML
	private JFXComboBox<EnumSexo> cbSexo;
	AlunoDAO aluno = new AlunoDAO();

	Aluno a = new Aluno();
	Curso c = new Curso();

	void pegaEnums() {
		cbCurso.getItems().add(null);
		cbSexo.getItems().add(null);
		cbCurso.getItems().addAll(EnumCurso.values());
		cbSexo.getItems().addAll(EnumSexo.values());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pegaEnums();

	}

	private void catchvalues() throws AlunoCadastroExceptionNome, CampoMatriculaException {

		validaNome();
		validaMatricula();

	}

	@FXML
	private void save(ActionEvent event)
			throws SQLException, AlunoCadastroExceptionNome, CampoMatriculaException, SexoNuloException {
		catchvalues();
		validaSexo();
		aluno.salvar(a, c);
		Limpar();

	}

	void validaNome() throws AlunoCadastroExceptionNome {

		StringBuilder builder = new StringBuilder();

		if (txtNome.getText().matches("[A-zA-Z ]+")) {
			a.setNome(txtNome.getText());
			c.setCurso(cbCurso.getValue());
			a.setEnumSexo(cbSexo.getValue());

		} else {
			throw new AlunoCadastroExceptionNome();
		}
		builder.append(txtNome.getText());
		if (txtNome.getText().isEmpty() || txtNome.getText() == null) {
			throw new AlunoCadastroExceptionNome();
		}

		String temp = builder.replace(1, 50, " ").toString();

		if (temp == " ") {
			throw new AlunoCadastroExceptionNome();
		}
	}

	void validaMatricula() throws CampoMatriculaException {

		if (txtMatricula.getText().matches("[0-9]+")) {
			a.setMatricula(txtMatricula.getText());
		} else if (txtMatricula.getText().matches(" ") || txtMatricula.getText().equals("  ")
				|| txtMatricula.getText().matches("[ -Z]+")) {
			throw new CampoMatriculaException();
		} else {
			throw new CampoMatriculaException();
		}

	}

	void validaSexo() throws SexoNuloException {
		if (cbSexo.getSelectionModel().getSelectedItem() == null) {
			throw new SexoNuloException();
		}
	}

	@FXML
	void cleanAll(ActionEvent event) {
		Limpar();
	}

	void Limpar() {
		txtMatricula.setText("");
		txtNome.setText("");
		cbCurso.getSelectionModel().clearAndSelect(0);
		cbSexo.getSelectionModel().clearAndSelect(0);
	}
}
