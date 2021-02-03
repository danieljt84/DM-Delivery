package com.danielmoreira.dsdelivery.model;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String endereco;
	private Double latitude;
	private Double longitude;
	private Instant momento;
	private Long telefone;
	private String nome;
	private StatusPedido status;
	private Double total;
	
	@ElementCollection
	@MapKeyJoinColumn(name = "produto_id")
	@Column(name = "quantidade")
	@CollectionTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"))
	private Map<Produto, Integer> produtos = new HashMap<Produto, Integer>();

	public Pedido(Long id, String endereco, Double latitude, Double longitude, Instant momento, StatusPedido status,
			String nome, Long telefone, Double total) {
		this.id = id;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.momento = momento;
		this.status = status;
		this.total = total;
		this.nome = nome;
		this.telefone = telefone;
	}

}
