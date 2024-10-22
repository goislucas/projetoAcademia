package com.example.demo.controllers;

import com.example.demo.dtos.PlanoRecordDto;
import com.example.demo.models.PlanoModel;
import com.example.demo.repositorio.PlanoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlanoController {

    @Autowired
    PlanoRepository planoRepository;

    @GetMapping("/plano")
    public ResponseEntity<List<PlanoModel>> getAllPlanos(){
        return ResponseEntity.status(HttpStatus.OK).body(planoRepository.findAll());
    }

    @GetMapping("/plano/{id}")
    public ResponseEntity<Object> getOnePlano(@PathVariable(value="id") Integer id){
        Optional<PlanoModel> planoO = planoRepository.findById(id);
        if(planoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plano não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(planoO.get());
    }

    @PostMapping("/plano")
    public ResponseEntity<PlanoModel> savePlano(@RequestBody @Valid PlanoRecordDto planoRecordDto) {

        var planoModel = new PlanoModel();
        BeanUtils.copyProperties(planoRecordDto, planoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(planoRepository.save(planoModel));


    }

    @PutMapping("plano/{id}")
    public ResponseEntity<Object> updatePlano(@PathVariable(value="id") Integer id,
                                              @RequestBody @Valid PlanoRecordDto planoRecordDto) {
        Optional<PlanoModel> planoO = planoRepository.findById(id);
        if(planoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plano não encontrado.");
        }
        var planoModel = planoO.get();
        BeanUtils.copyProperties(planoRecordDto, planoModel);
        return ResponseEntity.status(HttpStatus.OK).body(planoRepository.save(planoModel));
    }

    @DeleteMapping("plano/{id}")
    public ResponseEntity<Object> deletePlano(@PathVariable(value="id") Integer id) {
        Optional<PlanoModel> planoO = planoRepository.findById(id);
        if(planoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plano não encontrado");
        }
        planoRepository.delete(planoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Plano deletado com sucesso.");
    }
}

