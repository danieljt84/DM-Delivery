package com.danielmoreira.dsdelivery.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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
	
	private List<ProdutoDto> produtos;
	
	public PedidoDto(Pedido pedido) {
		this.id=pedido.getId();
		this.endereco=pedido.getEndereco();
		this.latitude=pedido.getLatitude();
		this.longitude=pedido.getLongitude();
		this.momento=pedido.getMomento();
		this.status=pedido.getStatus();
		this.total=pedido.getTotal();
		this.produtos = pedido.getProdutos().stream().map(x -> new ProdutoDto(x)).collect(Collectors.toList());
	}
}
