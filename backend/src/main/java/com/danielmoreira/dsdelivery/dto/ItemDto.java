package com.danielmoreira.dsdelivery.dto;

import com.danielmoreira.dsdelivery.model.Item;

import lombok.Value;

@Value
public class ItemDto {
	
	private ProdutoDto produto;
	private Long quantidade;
	
	
	
	public Item converteForm() {
		return new Item(this.produto.convertDto(),this.quantidade);
	}



	public ItemDto(Item item) {
		this.produto= new ProdutoDto(item.getProduto());
		this.quantidade = item.getQuantidade();
	}

}
