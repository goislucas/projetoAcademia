package com.example.demo.controllers;

import com.example.demo.dtos.ModalidadeRecordDto;
import com.example.demo.models.ModalidadeModel;
import com.example.demo.repositorio.ModalidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ModalidadeController {

    @Autowired
    ModalidadeRepository modalidadeRepository;

    @GetMapping("/modalidade")
    public ResponseEntity<List<ModalidadeModel>> getAllModalidades(){
        return ResponseEntity.status(HttpStatus.OK).body(modalidadeRepository.findAll());
    }

    @GetMapping("/modalidade/{id}")
    public ResponseEntity<Object> getOneModalidade(@PathVariable(value="id") Integer id){
        Optional<ModalidadeModel> modalidadeO = modalidadeRepository.findById(id);
        if(modalidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modalidade não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(modalidadeO.get());
    }

    @PostMapping("/modalidade")
    public ResponseEntity<ModalidadeModel> saveModalidade(@RequestBody @Valid ModalidadeRecordDto modalidadeRecordDto) {

        var modalidadeModel = new ModalidadeModel();
        BeanUtils.copyProperties(modalidadeRecordDto, modalidadeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(modalidadeRepository.save(modalidadeModel));
    }

    @PutMapping("modalidade/{id}")
    public ResponseEntity<Object> updateModalidade(@PathVariable(value="id") Integer id,
                                              @RequestBody @Valid ModalidadeRecordDto modalidadeRecordDto) {
        Optional<ModalidadeModel> modalidadeO = modalidadeRepository.findById(id);
        if(modalidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modalidade não encontrada.");
        }
        var modalidadeModel = modalidadeO.get();
        BeanUtils.copyProperties(modalidadeRecordDto, modalidadeModel);
        return ResponseEntity.status(HttpStatus.OK).body(modalidadeRepository.save(modalidadeModel));
    }

    @DeleteMapping("modalidade/{id}")
    public ResponseEntity<Object> deleteModalidade(@PathVariable(value="id") Integer id) {
        Optional<ModalidadeModel> modalidadeO = modalidadeRepository.findById(id);
        if(modalidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modalidade não encontrada");
        }
        modalidadeRepository.delete(modalidadeO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Modalidade deletada com sucesso.");
    }
}
