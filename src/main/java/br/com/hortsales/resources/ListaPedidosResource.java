package br.com.hortsales.resources;

import br.com.hortsales.domain.ListaPedidos;
import br.com.hortsales.domain.dtos.ListaPedidosDTO;
import br.com.hortsales.services.ListaPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/lista-pedidos")
public class ListaPedidosResource {

    @Autowired
    private ListaPedidosService service;

    @GetMapping
    public ResponseEntity<List<ListaPedidosDTO>> findAllListaPedidos() {
        List<ListaPedidos> list = service.findAllListaPedidos();
        List<ListaPedidosDTO> listDto = list.stream()
                .map(ped -> new ListaPedidosDTO(ped)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<ListaPedidosDTO> createListaPedidos(@Valid @RequestBody ListaPedidosDTO objDto) {
        ListaPedidos newObj = service.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
