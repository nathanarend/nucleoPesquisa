package br.com.unialfa.nupes.entity;

import br.com.unialfa.nupes.enumerator.EnumGrauAcademico;

public class Professor extends Pessoa {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrientador() {
		return Orientador;
	}

	public void setOrientador(String orientador) {
		Orientador = orientador;
	}

	public String getLeitor() {
		return Leitor;
	}

	public void setLeitor(String leitor) {
		Leitor = leitor;
	}

	private String Orientador;
	private String Leitor;
	private String matricula;
	private String titulacao;
	private int id_curso;
	EnumGrauAcademico enumGrauAcademico;

	public EnumGrauAcademico getEnumGrauAcademico() {
		return enumGrauAcademico;
	}

	public void setEnumGrauAcademico(EnumGrauAcademico enumGrauAcademico) {
		this.enumGrauAcademico = enumGrauAcademico;
	}

	public Professor() {

	}

	public Professor(String matricula, String titulacao, int id_curso) {
		this.matricula = matricula;
		this.titulacao = titulacao;
		this.id_curso = id_curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	@Override
	public String toString() {
		return nome;
	}

}
