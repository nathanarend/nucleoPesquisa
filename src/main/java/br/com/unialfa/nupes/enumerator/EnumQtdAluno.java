package br.com.unialfa.nupes.enumerator;

public enum EnumQtdAluno {
	UM_ALUNO(1L, "1"), DOIS_ALUNOS(2L, "2"), TRES_ALUNOS(3L, "3");

	private Long id;
	private String qtd;

	private EnumQtdAluno(Long id, String qtd) {
		this.id = id;
		this.qtd = qtd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQtd() {
		return qtd;
	}

	public void setQtd(String qtd) {
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return qtd;
	}
}
