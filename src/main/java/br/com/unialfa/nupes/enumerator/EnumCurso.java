package br.com.unialfa.nupes.enumerator;

public enum EnumCurso {
	SISTEMAS_DE_INFORMAÇÃO(1L, "SISTEMAS DE INFORMAÇÃO"), ADMINISTRAÇÃO(2L, "ADMINISTRAÇÃO"),
	ARQUITETURA_URBANISMO(3L, "ARQUITETURA E URBANISMO"), CIENCIAS_CONTABEIS(4L, "CIÊNCIAS CONTÁBEIS"),
	CIENCIAS_ECONOMICAS(5L, "CIÊNCIAS ECONÔMICAS"), COMÉRCIO_EXTERIOR(6L, "COMÉRCIO EXTERIOR"), DIREITO(7L, "DIREITO"),
	ENGENHARIA_CIVIL(8L, "ENGENHARIA CIVIL"), ENGENHARIA_COMPUTACAO(9L, "EGENHARIA DA COMPUTAÇÃO"),
	ENGENHARIA_DE_PRODUÇÃO(10L, "ENGENHARIA DE PRODUÇÃO"), ENGENHARIA_ELETRICA(11L, "ENGENHARIA ELÉTRICA"),
	ENGENHARIA_MECACINA(12L, "ENGENHARIA MECÂNICA"), JORNALISMO(13L, "JORNALISMO"), PEDAGOGIA(14L, "PEDAGOGIA"),
	PSICOLOGIA(15L, "PSICOLOGIA"), PUBLICIDADE_PROPAGANDA(16L, "PUBLICIDADE E PROPAGANDA");
	private Long id;
	private String nomeCurso;

	private EnumCurso(Long id, String nomeCurso) {
		this.id = id;
		this.nomeCurso = nomeCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return nomeCurso;
	}

	@Override
	public String toString() {
		return nomeCurso;
	}
}
