package com.danielmoreira.dsdelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielmoreira.dsdelivery.dto.ProdutoDto;
import com.danielmoreira.dsdelivery.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> listar(){
		List<ProdutoDto> list = produtoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	

}
