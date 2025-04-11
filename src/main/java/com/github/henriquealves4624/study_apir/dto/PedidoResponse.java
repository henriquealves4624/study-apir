package com.github.henriquealves4624.study_apir.dto;

import java.util.List;

public class PedidoResponse {

    private Long id;
    private String status;
    private List<ItensResponse> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItensResponse> getItems() {
        return items;
    }

    public void setItems(List<ItensResponse> items) {
        this.items = items;
    }

}
