package com.danielmoreira.dsdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielmoreira.dsdelivery.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
