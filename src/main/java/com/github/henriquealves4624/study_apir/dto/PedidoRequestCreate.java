package com.github.henriquealves4624.study_apir.dto;


import com.github.henriquealves4624.study_apir.model.Pedido;

public class PedidoRequestCreate {
 
    private String status;

    public Pedido toModel() {

        Pedido pedido = new Pedido();
        pedido.setStatus(this.status);
        return pedido;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
