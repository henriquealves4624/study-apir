package com.github.henriquealves4624.study_apir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.henriquealves4624.study_apir.dto.pedido.PedidoRequestCreate;
import com.github.henriquealves4624.study_apir.dto.pedido.PedidoRequestUpdate;
import com.github.henriquealves4624.study_apir.model.Itens;
import com.github.henriquealves4624.study_apir.model.Pedido;
import com.github.henriquealves4624.study_apir.model.Product;
import com.github.henriquealves4624.study_apir.repository.ItensRepository;
import com.github.henriquealves4624.study_apir.repository.PedidoRepository;
import com.github.henriquealves4624.study_apir.repository.ProductRepository;

@Service
public class PedidoService {
    @Autowired
    private ItensRepository itemRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductRepository produtoRepository;

    public Pedido create(PedidoRequestCreate dto) {
        Pedido pedido  = new Pedido();          
        pedido.setStatus("ABERTO");
        List<Itens> items = dto.getItems().stream()
                    .map(i -> {
                        Itens item = new Itens();                                                                         
                        Product produto = produtoRepository
                            .findById(i.getProductById)                            
                            .orElseThrow(() ->
                            new RuntimeException("Produto inexistente: " + i.getProductById())
                            );

                        item.setProduto(produto);
                        item.setValor(i.getValor());
                        item.setQuantidade(i.getQuantidade());
                        item.setPedido(pedido);                        
                        return item;
                    })
                    .collect(Collectors.toList());
        
        pedido.setItems(items);
        return pedidoRepository.save(pedido);
    }
    // public boolean delete(Long id) {
    //     return false;
    // }
    public Optional<Pedido> update(Long id, PedidoRequestUpdate dto) {
        return pedidoRepository.findById(id)
            .map(p -> pedidoRepository.save(p));

    }
    public Optional<Pedido> getById(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }    
}
