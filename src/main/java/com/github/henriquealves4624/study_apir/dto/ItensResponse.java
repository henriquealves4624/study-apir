package com.github.henriquealves4624.study_apir.dto;

import java.math.BigDecimal;

import com.github.henriquealves4624.study_apir.model.Itens;

public class ItensResponse {
    
    private Long id;
    private Long pedido_id;
    private Long produto_id;
    private Long quantidade;
    private BigDecimal valor;

    public ItensResponse toDto(Itens itens) {
        this.setId(itens.getId());
        this.setPedido_id(itens.getPedido_id());
        this.setProduto_id(itens.getProduto_id());
        this.setQuantidade(itens.getQuantidade());
        this.setValor(itens.getValor());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    

}
