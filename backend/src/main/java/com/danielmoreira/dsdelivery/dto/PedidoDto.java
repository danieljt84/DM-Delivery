package com.danielmoreira.dsdelivery.dto;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.danielmoreira.dsdelivery.model.Item;
import com.danielmoreira.dsdelivery.model.Pedido;
import com.danielmoreira.dsdelivery.model.StatusPedido;

import lombok.Value;

@Value
public class PedidoDto{
	
	private Long id;
	private String endereco;
	private Double latitude;
	private Double longitude;
	private Instant momento;
	private StatusPedido status;
	private Double total;
	private Set<ItemDto> itens;
	
	public PedidoDto(Pedido pedido) {
		this.id=pedido.getId();
		this.endereco=pedido.getEndereco();
		this.latitude=pedido.getLatitude();
		this.longitude=pedido.getLongitude();
		this.momento=pedido.getMomento();
		this.status=pedido.getStatus();
		this.total=pedido.getTotal();
		this.itens = converteItens(pedido.getItens());
	}
	
	public Set<ItemDto> converteItens(Set<Item> itens){
		return itens.stream().map(ItemDto::new).collect(Collectors.toSet());
	}
}
