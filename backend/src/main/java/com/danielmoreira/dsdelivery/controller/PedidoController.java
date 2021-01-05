package com.danielmoreira.dsdelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielmoreira.dsdelivery.dto.PedidoDto;
import com.danielmoreira.dsdelivery.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<PedidoDto>> listar(){
		List<PedidoDto> list = pedidoService.findAll();
		return ResponseEntity.ok().body(list);
	}

}
