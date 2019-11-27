package br.edu.ifms.model;

public enum TipoQuarto {
	
	COMUM("Comum"),
	EXECUTIVO("Executivo"),
	PRESIDENCIAL("Presidencial");
	
	private String descricao;
	
	TipoQuarto(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
