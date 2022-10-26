package br.com.hortsales.domain;

import br.com.hortsales.domain.enums.CondicaoProduto;
import br.com.hortsales.domain.enums.UnidadeMedida;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Embeddable
public class Pedido {

    @NotNull(message = "Produto NÃO pode ser nulo")
    private String produto;
    @NotNull(message = "Quantidade NÃO pode ser nulo")
    private String quantidade;

    @NotNull(message = "Condição do produto NÃO pode ser nulo")
    @Enumerated(EnumType.STRING)
    private CondicaoProduto condicaoProduto;

    @NotNull(message = "Unidade de media NÃO pode ser nulo")
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;


    public Pedido() {
    }

    public Pedido(String produto, String quantidade, CondicaoProduto condicaoProduto, UnidadeMedida unidadeMedida) {
        super();
        this.produto = produto;
        this.quantidade = quantidade;
        this.condicaoProduto = condicaoProduto;
        this.unidadeMedida = unidadeMedida;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public CondicaoProduto getCondicaoProduto() {
        return condicaoProduto;
    }

    public void setCondicaoProduto(CondicaoProduto condicaoProduto) {
        this.condicaoProduto = condicaoProduto;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
}


