package com.danielmoreira.dsdelivery.form;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.danielmoreira.dsdelivery.dto.ProdutoDto;
import com.danielmoreira.dsdelivery.model.Pedido;
import com.danielmoreira.dsdelivery.model.Produto;
import com.danielmoreira.dsdelivery.model.StatusPedido;

import lombok.Data;
@Data
public class PedidoForm {
	
	private Long id;
	private String endereco;
	private Double latitude;
	private Double longitude;
	private Instant momento;
	private StatusPedido status;
	private Double total;
	private Set<ProdutoDto> produtos;
	
	
	public Pedido converteForm(){
		return new Pedido(this.id,this.endereco,this.latitude,this.longitude,Instant.now(),this.status.PENDENTE,this.total);
	}

}