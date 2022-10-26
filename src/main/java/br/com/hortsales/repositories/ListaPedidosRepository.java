package br.com.hortsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hortsales.domain.ListaPedidos;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListaPedidosRepository extends JpaRepository<ListaPedidos, Integer> {

    @Query(value = "SELECT * FROM lista_pedidos", nativeQuery = true)
    List<ListaPedidos> findAllPedido();
}
