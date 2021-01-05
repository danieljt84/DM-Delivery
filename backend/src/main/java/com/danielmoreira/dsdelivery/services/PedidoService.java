package com.danielmoreira.dsdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danielmoreira.dsdelivery.dto.PedidoDto;
import com.danielmoreira.dsdelivery.dto.ProdutoDto;
import com.danielmoreira.dsdelivery.form.PedidoForm;
import com.danielmoreira.dsdelivery.model.Pedido;
import com.danielmoreira.dsdelivery.model.Produto;
import com.danielmoreira.dsdelivery.repository.PedidoRepository;
import com.danielmoreira.dsdelivery.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional(readOnly = true)
	public List<PedidoDto> findAll(){
		List<Pedido> list = pedidoRepository.findPedidoComProduto();
		return list.stream().map(x -> new PedidoDto(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public PedidoDto salvar(PedidoForm form) {
		Pedido pedido = form.converteForm();
		
		for (ProdutoDto p : form.getProdutos()) {
			Produto produto = produtoRepository.getOne(p.getId());
			pedido.getProdutos().add(produto);
		}
		pedido = pedidoRepository.save(pedido);
		return new PedidoDto(pedido);
	}

}
