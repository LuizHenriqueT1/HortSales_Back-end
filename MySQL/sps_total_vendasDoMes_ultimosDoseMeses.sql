DELIMITER //
	CREATE PROCEDURE sps_faturamentos_ultimosDozeMeses()
		BEGIN 
			SELECT 
				EXTRACT(MONTH FROM data_do_valor) AS Mes,
				EXTRACT(YEAR FROM data_do_valor) AS Ano,
				ROUND(SUM(lucro_dia),2) AS TotalVendas
				FROM casher
				WHERE data_do_valor BETWEEN CURRENT_DATE() - INTERVAL 12 MONTH AND CURRENT_DATE() 
				GROUP BY mes, ano
				ORDER BY ano DESC, mes DESC;
		END //
DELIMITER ;
CALL sps_faturamentos_ultimosDozeMeses();





    