package br.edu.ifms.model;

public enum Disponibilidade {
	DISPONIVEL("Dispon�vel"),
	OCUPADO("Ocupado"),
	EM_MANUTENCAO("Em manuten��o"),
	EM_LIMPEZA("Em limpeza"),
	FECHADO("Fechado");
	
	private String descricao;
	
	Disponibilidade(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
