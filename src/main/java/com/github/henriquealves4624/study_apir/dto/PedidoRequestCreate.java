package com.github.henriquealves4624.study_apir.dto;

import java.util.List;

import com.github.henriquealves4624.study_apir.model.Pedido;

public class PedidoRequestCreate {

    private List<ItemRequestCreate> items;
   
    public List<ItemRequestCreate> getItems() {
        return items;
    }

    public void setItems(List<ItemRequestCreate> items) {
        this.items = items;
    }

}
