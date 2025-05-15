package com.github.henriquealves4624.study_apir.dto;

import com.github.henriquealves4624.study_apir.model.Pedido;
import com.github.henriquealves4624.study_apir.model.Product;

public class PedidoRequestUpdate {

    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Product toModel(Product product) {
        product.setValor(this.valor);
        return product;
    }

}
