package com.github.henriquealves4624.study_apir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.henriquealves4624.study_apir.dto.ItensRequestCreate;
import com.github.henriquealves4624.study_apir.dto.ItensRequestUpdate;
import com.github.henriquealves4624.study_apir.model.Itens;
import com.github.henriquealves4624.study_apir.repository.ItensRepository;

public class ItensService {
    
    @Autowired
    private ItensRepository itensRepository;

    public Itens createProduct(ItensRequestCreate dto) {
        return itensRepository.save(dto.toModel());
    }

    public Optional<Itens> getItensById(Long id) {

        return itensRepository.findById(id);

    }

    public List<Itens> getAll() {
        return itensRepository.findAll();
    }

    public Optional<Itens> updateItens(
            Long id, ItensRequestUpdate dto) {

        return itensRepository.findById(id)
                .map(p -> itensRepository.save(dto.toModel(p)));

    }

    public boolean deleteProduct(Long id) {  

        if (itensRepository.existsById(id)) {
            itensRepository.deleteById(id);
            return true;
        }

        return false;

    }

}
