package br.com.unialfa.nupes.entity;

public class Declaracao {
	private String nProfOrientador2;
	private String nProfOrientador;
	private String semestre;
	private String nomeBanca;
	private String aluno1;
	private String aluno2;
	private String aluno3;
	private String nomeCurso;
	private String nProfLeitor1;
	private String nProfLeitor2;

	public String getnProfOrientador2() {
		return nProfOrientador2;
	}

	public void setnProfOrientador2(String nProfOrientador2) {
		this.nProfOrientador2 = nProfOrientador2;
	}

	public String getnProfOrientador() {
		return nProfOrientador;
	}

	public void setnProfOrientador(String nProfOrientador) {
		this.nProfOrientador = nProfOrientador;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getNomeBanca() {
		return nomeBanca;
	}

	public void setNomeBanca(String nomeBanca) {
		this.nomeBanca = nomeBanca;
	}

	public String getAluno1() {
		return aluno1;
	}

	public void setAluno1(String aluno1) {
		this.aluno1 = aluno1;
	}

	public String getAluno2() {
		return aluno2;
	}

	public void setAluno2(String aluno2) {
		this.aluno2 = aluno2;
	}

	public String getAluno3() {
		return aluno3;
	}

	public void setAluno3(String aluno3) {
		this.aluno3 = aluno3;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getnProfLeitor1() {
		return nProfLeitor1;
	}

	public void setnProfLeitor1(String nProfLeitor1) {
		this.nProfLeitor1 = nProfLeitor1;
	}

	public String getnProfLeitor2() {
		return nProfLeitor2;
	}

	public void setnProfLeitor2(String nProfLeitor2) {
		this.nProfLeitor2 = nProfLeitor2;
	}

	@Override
	public String toString() {
		return nomeBanca;
	}

}
