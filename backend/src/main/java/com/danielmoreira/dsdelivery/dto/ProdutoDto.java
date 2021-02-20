package com.danielmoreira.dsdelivery.dto;

import java.io.Serializable;

import com.danielmoreira.dsdelivery.model.Produto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
public class ProdutoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;	
	private String imagemUri;
	
	public ProdutoDto() {
		
	}
	
	public ProdutoDto(Produto x) {
		this.id=x.getId();
		this.descricao=x.getDescricao();
		this.nome=x.getNome();
		this.preco = x.getPreco();
		this.imagemUri = x.getImagemUri();
	}
	
	public Produto convertDto() {
		return new Produto(this.id,this.descricao,this.nome,this.preco);
	}

}
