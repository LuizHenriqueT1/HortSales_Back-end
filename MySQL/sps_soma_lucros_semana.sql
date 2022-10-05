USE heroku_2d499b705044693;
DELIMITER //
	CREATE PROCEDURE sps_soma_lucros_semana()
    BEGIN 
		SELECT ROUND(SUM(lucro_dia), 2) as soma_da_semana
        FROM casher
		WHERE data_do_valor  BETWEEN CURRENT_DATE - INTERVAL 7 DAY AND CURRENT_DATE();
    END //
DELIMITER ;
DROP PROCEDURE sps_soma_lucros_semana;
CALL sps_soma_lucros_semana();
