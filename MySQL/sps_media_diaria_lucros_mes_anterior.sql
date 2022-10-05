USE heroku_2d499b705044693;
DELIMITER //
	CREATE PROCEDURE sps_media_diaria_lucros_mes_anterior()
		BEGIN
			SELECT  ROUND(ROUND(SUM(lucro_dia), 2) / DAY(LAST_DAY( CURRENT_DATE - INTERVAL 1 MONTH )),2) as media_diaria_mes_anterior
            FROM casher;
		END //
DELIMITER ;
DROP PROCEDURE sps_media_diaria_lucros_mes_anterior;
CALL sps_media_diaria_lucros_mes_anterior();
