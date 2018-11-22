package br.com.unialfa.nupes.enumerator;

public enum EnumGrauAcademico {
	MESTRE(1L,"Me."), MESTRA(2L,"Ma."),DOUTOR(3L,"Dr."),DOUTORA(4L,"Dra.");
	
	
	private Long id;
	private String grau;

	private EnumGrauAcademico(Long id, String grau) {
		this.id = id;
		this.grau = grau;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.grau;
	}

}
