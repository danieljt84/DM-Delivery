package com.danielmoreira.dsdelivery.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.danielmoreira.dsdelivery.dto.PedidoDto;
import com.danielmoreira.dsdelivery.dto.ProdutoDto;
import com.danielmoreira.dsdelivery.form.PedidoForm;
import com.danielmoreira.dsdelivery.model.Pedido;
import com.danielmoreira.dsdelivery.model.StatusPedido;
import com.danielmoreira.dsdelivery.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoDto>> listar() {
		List<PedidoDto> list = pedidoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<StatusPedido> listar(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
		PedidoDto pedido = pedidoService.buscarPedido(id);
		URI uri = uriBuilder.path("/pedidos/buscar/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(pedido.getStatus());

	}

	@PostMapping()
	public ResponseEntity<Long> salvar(@RequestBody PedidoForm form, UriComponentsBuilder uriBuilder) {
		PedidoDto dto = pedidoService.salvar(form);
		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto.getId());
	}

	@PutMapping("/{id}")
	public ResponseEntity<PedidoDto> alterar(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
		PedidoDto dto = pedidoService.alterar(id);
		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
