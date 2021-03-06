package com.danielmoreira.dsdelivery.form;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import com.danielmoreira.dsdelivery.dto.ItemDto;
import com.danielmoreira.dsdelivery.model.Item;
import com.danielmoreira.dsdelivery.model.Pedido;
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
	private Long telefone;
	private String nome;
	private Set<Item> itens;

	public Pedido converteForm() {
		return new Pedido(this.id, this.endereco, this.latitude, this.longitude, this.momento.now(),
				StatusPedido.PENDENTE, this.nome, this.telefone, this.total, this.itens);
	}

	/*public Set<Item> converteItens(){
		return this.itens.stream().map(x -> x.converteForm()).collect(Collectors.toSet());
	}
	*/

}