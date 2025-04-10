package com.github.henriquealves4624.study_apir.dto;

import java.math.BigDecimal;

import com.github.henriquealves4624.study_apir.model.Itens;

public class ItensRequestCreate {
    
    Long pedido_id;
    Long produto_id;
    Long quantidade;
    BigDecimal valor;

    public Itens toModel() {

    BigDecimal VALOR_PADRAO = new BigDecimal(2000);

    Itens itens = new Itens();
    itens.setPedido_id(this.pedido_id);
    itens.setProduto_id(this.produto_id);
    itens.setQuantidade(this.quantidade);
    itens.setValor(VALOR_PADRAO);

    return itens;

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
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


    

}
