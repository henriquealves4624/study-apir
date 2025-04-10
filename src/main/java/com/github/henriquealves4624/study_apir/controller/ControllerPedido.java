package com.github.henriquealves4624.study_apir.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.henriquealves4624.study_apir.dto.PedidoRequestCreate;
import com.github.henriquealves4624.study_apir.dto.PedidoRequestUpdate;
import com.github.henriquealves4624.study_apir.dto.PedidoResponse;
import com.github.henriquealves4624.study_apir.service.PedidoService;

@RestController
@RequestMapping("pedidos")
public class ControllerPedido {

    @Autowired
    private PedidoService pedidoService;
    
    @PostMapping
    public ResponseEntity<PedidoResponse> create(
            @RequestBody PedidoRequestCreate dto) {

        return ResponseEntity.status(201).body(
                new PedidoResponse().toDto(pedidoService.createPedido(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = pedidoService.deleteProduct(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponse> update(@PathVariable Long id, @RequestBody PedidoRequestUpdate dto) {

        return pedidoService.updatePedido(id, dto)
                .map(p -> new PedidoResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> findById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id)
                .map(p -> new PedidoResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> findAll() {
        List<PedidoResponse> response = pedidoService.getAll().stream()
                .map(p -> new PedidoResponse().toDto(p))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }

}
