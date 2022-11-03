DELIMITER //
	CREATE PROCEDURE sps_total_vendasDoMes_ultimosDoseMeses()
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
DROP PROCEDURE sps_total_vendasDoMes_ultimosDoseMeses;
CALL sps_total_vendasDoMes_ultimosDoseMeses();

    