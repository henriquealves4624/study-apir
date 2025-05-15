package com.github.henriquealves4624.study_apir.dto.item;

import java.math.BigDecimal;

import com.github.henriquealves4624.study_apir.model.Itens;
import com.github.henriquealves4624.study_apir.model.Pedido;
import com.github.henriquealves4624.study_apir.model.Product;

public class ItemRequestUpdate {
    private BigDecimal valor;

    public Itens toModel(Pedido pedido, Product produto){
            
        Itens item = new Item();
        item.setValor(this.valor);
        item.setProduto(produto); 
        item.setPedido(pedido);       
        return item;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
