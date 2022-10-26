package br.com.hortsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hortsales.domain.ListaPedidos;

public interface ListaPedidosRepository extends JpaRepository<ListaPedidos, Integer> {
}
