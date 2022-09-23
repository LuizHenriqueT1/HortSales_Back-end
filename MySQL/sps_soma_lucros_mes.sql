use heroku_3c6694aa22a77ed;

DELIMITER //
 CREATE PROCEDURE sps_soma_lucros_mes(IN mes_da_media INT, IN ano_da_media INT)
	BEGIN 
		SELECT DATE_FORMAT(data_do_valor, CONCAT("%c", " %Y")) as mes_e_ano_do_valor, ROUND(SUM(lucro_dia), 2) as soma_do_mes
        FROM casher	
        WHERE Month(data_do_valor)=mes_da_media AND YEAR(data_do_valor)=ano_da_media;
    END //
DELIMITER ;
DROP PROCEDURE sps_soma_lucros_mes;
CALL sps_soma_lucros_mes('9', '2022');