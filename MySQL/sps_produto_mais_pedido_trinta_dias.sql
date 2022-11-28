DELIMITER //
	CREATE PROCEDURE sps_produto_mais_pedido_trinta_dias()
		 BEGIN
			SELECT 
				produto,
				SUM(quantidade) AS quantidade
				FROM pedido
				INNER JOIN lista_pedidos ON lista_pedidos.id = pedido.lista_pedidos_id
				WHERE data_do_pedido BETWEEN CURRENT_DATE() - INTERVAL 30 DAY AND CURRENT_DATE()
				GROUP BY produto
				ORDER BY quantidade DESC LIMIT 1;
         END //
DELIMITER ;
DROP PROCEDURE sps_produto_mais_pedido_trinta_dias;
CALL sps_produto_mais_pedido_trinta_dias();


