package br.com.hortsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hortsales.domain.ListaPedidos;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ListaPedidosRepository extends JpaRepository<ListaPedidos, Integer> {

    @Query(value = "SELECT * FROM lista_pedidos", nativeQuery = true)
    List<ListaPedidos> findAllPedido();

    @Query(value = "CALL sps_produto_mais_pedido_trinta_dias()", nativeQuery = true)
    Optional<List> findProdutoMaisPedidoUltimosTrintaDias();

    @Query(value = "CALL sps_produtos_mais_pedidos_doze_meses()", nativeQuery = true)
    Optional<List> findProdutosMaisPedidosUltimosDozeMeses();
}
