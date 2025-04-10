package com.github.henriquealves4624.study_apir.dto;

import com.github.henriquealves4624.study_apir.model.Itens;

public class ItensRequestUpdate {
    
    private Long quantidade;

    public Itens toModel(Itens itens) {

        itens.setQuantidade(this.quantidade);
        return itens;

    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

}
