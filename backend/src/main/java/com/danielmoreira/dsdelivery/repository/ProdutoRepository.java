package com.danielmoreira.dsdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielmoreira.dsdelivery.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findAllByOrderByNomeAsc();

}
