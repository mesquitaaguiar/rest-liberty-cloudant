package br.com.cameag.sistemas.enums;

public enum CloudantEnum {
	LOGIN("28e9e9be-25f2-4d7d3bb4e6fc-bluemix"),
	SENHA("e37466f9804fbed7cf998123dd90c635ff5b138c"),
	BANCO("ouvidoria");
	
	private final String descricao;
	
	private CloudantEnum(final String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
