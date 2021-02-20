package com.danielmoreira.dsdelivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


@Entity
@Data
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Produto produto;
	private Long quantidade;
	
	public Item(){}
	
	public Item(Produto produto, Long quantidade) {
		this.produto=produto;
		this.quantidade = quantidade;
	}


}
