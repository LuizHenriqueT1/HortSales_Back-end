SELECT * FROM casher WHERE data_do_valor;

DELIMITER //
 CREATE PROCEDURE sps_media_mes(IN mes_da_media INT, IN ano_da_media INT)
	BEGIN
		SELECT DATE_FORMAT(data_do_valor, CONCAT("%c", " %Y")) as mes_e_ano_da_media, ROUND(AVG(lucro_dia), 2) as media_vendas_mes
        FROM casher
        WHERE Month(data_do_valor)=mes_da_media AND YEAR(data_do_valor)=ano_da_media;
    END //
DELIMITER ;
DROP PROCEDURE sps_media_mes;
CALL sps_media_mes('9', '2022');



