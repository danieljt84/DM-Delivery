package com.danielmoreira.dsdelivery.form;

import lombok.Value;

@Value
public class ProdutoForm {
	
	private Long id;
	private String nome;
	private String Descricao;
	private Double preco;

}
