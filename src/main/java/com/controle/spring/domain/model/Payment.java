package com.controle.spring.domain.model;

public enum Payment {

	DINHEIRO(1, "DINHEIRO"),
	CARTAO_CREDITO(2, "CARTÃO DE CRÉDITO"),
	CARTAO_DEBITO(3,"CARTÃO DE DEBITO"),
	BRINDE(4,"BRINDE"),
	PIX(5,"PIX"),
	OUTROS(6,"OUTROS");

	private Integer cod;
	private String description;

	private Payment(Integer cod, String descricao) {
		this.cod = cod;
		this.description = descricao;
	}
	
	public static String descriptionCod(Integer value){
		String retorno = "";
		for(Payment cod : Payment.values()){
			if(cod.getCod().equals(value)){
				retorno = cod.getDescription();
				break;
			}
		}
		return retorno;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
}
