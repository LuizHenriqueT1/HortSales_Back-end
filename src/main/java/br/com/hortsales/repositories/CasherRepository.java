package br.com.hortsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.hortsales.domain.Casher;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CasherRepository extends JpaRepository<Casher, Integer> {

    @Query(value = "CALL sps_soma_lucros_mes(:mes, :ano)", nativeQuery = true)
    Optional<List> findSomaLucroByMesAno(Integer mes, Integer ano);

    @Query(value = "CALL sps_media_mes(:mes, :ano)", nativeQuery = true)
    Optional<List> findMediaLucroMesByMesAno(Integer mes, Integer ano);
    
    @Query(value = "CALL sps_soma_lucros_semana()", nativeQuery = true)
    Optional<List> findSomaLucrosUltimosSeteDias();

    @Query(value = "CALL sps_soma_lucros_ultimos_trinta_dias()", nativeQuery = true)
    Optional<List> findSomaLucrosUltimosTrintaDias();
}
