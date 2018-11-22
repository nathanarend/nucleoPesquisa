package br.com.unialfa.nupes.entity;

import br.com.unialfa.nupes.enumerator.EnumSexo;

public class Pessoa {

	String matricula;
	String nome;
	int id;
	String sexo;
	EnumSexo enumSexo;

	public EnumSexo getEnumSexo() {
		return enumSexo;
	}

	public void setEnumSexo(EnumSexo enumSexo) {
		this.enumSexo = enumSexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa() {
	}

	public Pessoa(String matricula, String nome) {

		this.matricula = matricula;
		this.nome = nome;

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
