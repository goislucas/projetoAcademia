package com.example.demo.repositorio;

import com.example.demo.models.ModalidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadeRepository extends JpaRepository<ModalidadeModel, Integer>{
}