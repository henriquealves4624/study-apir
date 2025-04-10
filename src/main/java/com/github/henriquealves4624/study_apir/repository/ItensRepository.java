package com.github.henriquealves4624.study_apir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.henriquealves4624.study_apir.model.Itens;

@Repository
public interface ItensRepository extends JpaRepository<Itens, Long> {

}
