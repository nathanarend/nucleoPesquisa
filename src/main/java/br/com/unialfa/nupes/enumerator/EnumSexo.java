package br.com.unialfa.nupes.enumerator;

public enum EnumSexo {
	SEXO_MASC(1L, "M"), SEXO_FEM(2L, "F");

	private EnumSexo(Long id, String sexo) {
		this.id = id;
		this.sexo = sexo;
	}

	private Long id;
	private String sexo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sexo;
	}
}
