package com.example.demo.repositorio;

import com.example.demo.PlanoIncluiModalidadeId;
import com.example.demo.models.PlanoIncluiModalidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoIncluiModalidadeRepository extends JpaRepository<PlanoIncluiModalidadeModel, PlanoIncluiModalidadeId>{
}