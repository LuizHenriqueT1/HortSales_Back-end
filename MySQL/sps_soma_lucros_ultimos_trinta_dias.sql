USE heroku_2d499b705044693;
DELIMITER //
	CREATE PROCEDURE sps_soma_lucros_ultimos_trinta_dias()
    BEGIN 
		SELECT ROUND(SUM(lucro_dia), 2) as soma_lucros_ultimo_mes
        FROM casher
		WHERE data_do_valor  BETWEEN CURRENT_DATE() - INTERVAL 30 DAY AND CURRENT_DATE();
    END //
DELIMITER ;
DROP PROCEDURE sps_soma_lucros_ultimos_trinta_dias;
CALL sps_soma_lucros_ultimos_trinta_dias();


