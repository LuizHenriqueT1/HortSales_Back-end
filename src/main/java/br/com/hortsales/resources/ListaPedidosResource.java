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

    @PostMapping
    public ResponseEntity<ListaPedidosDTO> createListaPedidos(@Valid @RequestBody ListaPedidosDTO objDto) {
        ListaPedidos newObj = service.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<ListaPedidosDTO>> findAllPedido() {
        List<ListaPedidos> list = service.findAllPedido();
        List<ListaPedidosDTO> listDto = list.stream().map(obj -> new ListaPedidosDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/produto-mais-pedido-ultimos-trintadias")
    public ResponseEntity findProdutoMaisPedidoUltimosTrintaDias() {
        List obj = service.findProdutoMaisPedidoUltimosTrintaDias();
        return ResponseEntity.ok().body(obj);
    }
}
