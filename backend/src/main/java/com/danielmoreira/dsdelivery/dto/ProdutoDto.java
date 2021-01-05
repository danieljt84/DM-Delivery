package com.danielmoreira.dsdelivery.dto;

import java.io.Serializable;

import com.danielmoreira.dsdelivery.model.Produto;

import lombok.Value;

@Value
public class ProdutoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String descricao;
	private String imagemUri;
	private Double preco;
	
	public ProdutoDto(Produto x) {
		this.id=x.getId();
		this.descricao=x.getDescricao();
		this.nome=x.getNome();
		this.imagemUri = x.getImagemUri();
		this.preco = x.getPreco();
	}

}
