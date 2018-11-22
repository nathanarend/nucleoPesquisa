package br.com.unialfa.nupes.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import br.com.unialfa.nupes.dao.CursoDAO;
import br.com.unialfa.nupes.entity.Curso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CursoController {
	Curso c = new Curso();
	CursoDAO curso = new CursoDAO();

	@FXML
	private JFXTextField txtNomeCurso;

	@FXML
	private JFXButton btnSalvar;

	@FXML
	private JFXButton btnCancelar;

	void catchValues(Curso curso) {
		c.setNome(txtNomeCurso.getText());
	}

	@FXML
	void salvar(ActionEvent event) throws IOException {
		catchValues(c);
	}
}
