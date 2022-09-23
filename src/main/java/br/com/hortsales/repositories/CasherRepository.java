package br.com.hortsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.hortsales.domain.Casher;

import java.util.List;
import java.util.Optional;

public interface CasherRepository extends JpaRepository<Casher, Integer> {

    @Query(value = "CALL sps_soma_vendas_mes(:mes, :ano)", nativeQuery = true)
    Optional<List> findSomaLucroByMesAno(Integer mes, Integer ano);
}
