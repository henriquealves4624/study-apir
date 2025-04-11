// package com.github.henriquealves4624.study_apir.controller;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.github.henriquealves4624.study_apir.dto.ItensRequestCreate;
// import com.github.henriquealves4624.study_apir.dto.ItensRequestUpdate;
// import com.github.henriquealves4624.study_apir.dto.ItensResponse;
// import com.github.henriquealves4624.study_apir.service.ItensService;

// @RestController
// @RequestMapping("itens")
// public class ControllerItens {
    
//     @Autowired
//     private ItensService itensService;

//     @PostMapping
//     public ResponseEntity<ItensResponse> create(
//             @RequestBody ItensRequestCreate dto) {

//         return ResponseEntity.status(201).body(
//                 new ItensResponse().toDto(itensService.createProduct(dto)));
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> delete(@PathVariable Long id) {
//         boolean result = itensService.deleteProduct(id);

//         if (result) {
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<ItensResponse> update(@PathVariable Long id, @RequestBody ItensRequestUpdate dto) {

//         return itensService.updateItens(id, dto)
//                 .map(p -> new ItensResponse().toDto(p))
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ItensResponse> findById(@PathVariable Long id) {
//         return itensService.getItensById(id)
//                 .map(p -> new ItensResponse().toDto(p))
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     @GetMapping
//     public ResponseEntity<List<ItensResponse>> findAll() {
//         List<ItensResponse> response = itensService.getAll().stream()
//                 .map(p -> new ItensResponse().toDto(p))
//                 .collect(Collectors.toList());
//         return ResponseEntity.ok(response);

//     }

// }
