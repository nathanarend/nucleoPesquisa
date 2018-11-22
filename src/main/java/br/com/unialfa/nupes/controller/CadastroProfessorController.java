package br.com.unialfa.nupes.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.dao.ProfessorDAO;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.entity.Professor;
import br.com.unialfa.nupes.enumerator.EnumGrauAcademico;
import br.com.unialfa.nupes.enumerator.EnumSexo;
import br.com.unialfa.nupes.exception.MatriculaNulaException;
import br.com.unialfa.nupes.exception.NomeProfessorNuloException;
import br.com.unialfa.nupes.exception.SexoNuloException;
import br.com.unialfa.nupes.exception.TitularidadeExceptionValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadastroProfessorController implements Initializable {
	Professor professor = new Professor();
	Curso curso = new Curso();
//
	ProfessorDAO pd = new ProfessorDAO();
	@FXML
	private JFXTextField txtNome;

	@FXML
	private JFXButton btnSalvar, btnLimpar;

	@FXML
	private JFXTextField txtMatricula;

	@FXML
	private JFXComboBox<EnumGrauAcademico> cbTitularidade;

	@FXML
	private JFXComboBox<EnumSexo> cbSexo;

	void pegaEnum() {
		cbTitularidade.getItems().add(null);
		cbSexo.getItems().add(null);
		cbTitularidade.getItems().addAll(EnumGrauAcademico.values());
		cbSexo.getItems().addAll(EnumSexo.values());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pegaEnum();

	}

	private void catchitems() throws SexoNuloException,TitularidadeExceptionValue {
		professor.setNome(txtNome.getText());
		professor.setMatricula(txtMatricula.getText());
		professor.setEnumGrauAcademico(cbTitularidade.getValue());
		professor.setEnumSexo(cbSexo.getValue());
		
		if (cbSexo.getSelectionModel().getSelectedItem() == null) {
			throw new SexoNuloException();
		}
		if(cbTitularidade.getSelectionModel().getSelectedItem() == null) {
			throw new TitularidadeExceptionValue();
		}
	}

	@FXML
	private void save(ActionEvent event)
			throws SQLException, NomeProfessorNuloException, SexoNuloException, MatriculaNulaException, TitularidadeExceptionValue {
		catchitems() ;
		validaNome();
		validaMatricula();
		pd.salvar(professor, curso);
		limpa();

	}

	void validaNome() throws NomeProfessorNuloException {

		StringBuilder builder = new StringBuilder();

		if (txtNome.getText().matches("[A-zA-Z ]+")) {
			professor.setNome(txtNome.getText());

		} else {
			throw new NomeProfessorNuloException();
		}
		
			builder.append(txtNome.getText());
			if (txtNome.getText().isEmpty() || txtNome.getText() == null) {
				throw new NomeProfessorNuloException();
			}

			String temp = builder.replace(1, 50, " ").toString();
			if (temp == " ") {
				throw new NomeProfessorNuloException();
			}
		
	}

	void validaMatricula() throws MatriculaNulaException {

		if (txtMatricula.getText().matches("[0-9]+")) {
			professor.setMatricula(txtMatricula.getText());
		} else {
			throw new MatriculaNulaException();
		}
	}

	@FXML
	void cleanAll(ActionEvent event) {
		limpa();
	}

	void limpa() {
		cbSexo.getSelectionModel().clearAndSelect(0);
		txtMatricula.setText("");
		txtNome.setText("");
		cbTitularidade.getSelectionModel().clearAndSelect(0);
	}
}