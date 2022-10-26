package br.com.hortsales.domain.dtos;

import br.com.hortsales.domain.ListaPedidos;
import br.com.hortsales.domain.Pedido;
import br.com.hortsales.domain.enums.CondicaoProduto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListaPedidosDTO extends ListaPedidos {

    private Integer id;

    private List<Pedido> listaPedidos = new ArrayList<Pedido>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDoPedido = LocalDate.now();

    public ListaPedidosDTO() {
    }

    public ListaPedidosDTO(ListaPedidos obj) {
        super();
        this.id = obj.getId();
        this.listaPedidos = obj.getListaPedidos();
        this.dataDoPedido = obj.getDataDoPedido();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    @Override
    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public LocalDate getDataDoPedido() {
        return dataDoPedido;
    }

    @Override
    public void setDataDoPedido(LocalDate dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

}
