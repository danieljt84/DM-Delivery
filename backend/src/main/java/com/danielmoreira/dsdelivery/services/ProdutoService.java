package com.danielmoreira.dsdelivery.services;



import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danielmoreira.dsdelivery.dto.ProdutoDto;
import com.danielmoreira.dsdelivery.model.Produto;
import com.danielmoreira.dsdelivery.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	Produto produto = new Produto();


	@Transactional(readOnly = true)
	public List<ProdutoDto> findAll(){
		List<Produto> list = produtoRepository.findAllByOrderByNomeAsc();
		return list.stream().map(x -> new ProdutoDto(x)).collect(Collectors.toList());
	}

}
