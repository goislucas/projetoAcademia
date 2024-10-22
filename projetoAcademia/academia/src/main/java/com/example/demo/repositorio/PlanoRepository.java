package com.example.demo.repositorio;

import com.example.demo.models.PlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoModel, Integer>{
}
