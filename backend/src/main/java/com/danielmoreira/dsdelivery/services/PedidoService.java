package com.danielmoreira.dsdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danielmoreira.dsdelivery.dto.PedidoDto;
import com.danielmoreira.dsdelivery.model.Pedido;
import com.danielmoreira.dsdelivery.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional(readOnly = true)
	public List<PedidoDto> findAll(){
		List<Pedido> list = pedidoRepository.findPedidoComProduto();
		return list.stream().map(x -> new PedidoDto(x)).collect(Collectors.toList());
	}

}
