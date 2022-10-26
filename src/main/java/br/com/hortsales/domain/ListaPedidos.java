package br.com.hortsales.domain;

import br.com.hortsales.domain.dtos.ListaPedidosDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ListaPedidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    @CollectionTable(name = "pedido")
    private List<Pedido> listaPedidos = new ArrayList<Pedido>();


    private LocalDate dataDoPedido = LocalDate.now();

    public ListaPedidos() {

    }

    public ListaPedidos(Integer id, List<Pedido> listaPedidos, LocalDate dataDoPedido) {
        super();
        this.id = id;
        this.listaPedidos = listaPedidos;
        this.dataDoPedido = dataDoPedido;
    }

    public ListaPedidos(ListaPedidosDTO objDto) {
        super();
        this.id = objDto.getId();
        this.listaPedidos = objDto.getListaPedidos();
        this.dataDoPedido = objDto.getDataDoPedido();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }


    public LocalDate getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(LocalDate dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }
}
