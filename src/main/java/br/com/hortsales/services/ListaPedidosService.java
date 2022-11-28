package br.com.hortsales.services;


import br.com.hortsales.domain.ListaPedidos;
import br.com.hortsales.domain.dtos.ListaPedidosDTO;
import br.com.hortsales.repositories.ListaPedidosRepository;
import br.com.hortsales.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ListaPedidosService {

    @Autowired
    private ListaPedidosRepository repository;

    public List<ListaPedidos> findAllListaPedidos() {
        return repository.findAll();
    }

    public ListaPedidos create(@Valid ListaPedidosDTO objDto) {
        objDto.setId(null);
        ListaPedidos newObj = new ListaPedidos(objDto);
        return repository.save(newObj);
    }

    public List<ListaPedidos> findAllPedido() {
        return repository.findAllPedido();
    }

    public List findProdutoMaisPedidoUltimosTrintaDias() {
        Optional<List> obj = repository.findProdutoMaisPedidoUltimosTrintaDias();
        return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum valor encontrado!!"));
    }
}
