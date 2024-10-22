package com.example.demo.controllers;

import com.example.demo.PlanoIncluiModalidadeId;
import com.example.demo.dtos.PlanoIncluiModalidadeRecordDto;
import com.example.demo.models.ModalidadeModel;
import com.example.demo.models.PlanoIncluiModalidadeModel;
import com.example.demo.models.PlanoModel;
import com.example.demo.repositorio.ModalidadeRepository;
import com.example.demo.repositorio.PlanoIncluiModalidadeRepository;
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
public class PlanoIncluiModalidadeController {

    @Autowired
    PlanoIncluiModalidadeRepository planoIncluiModalidadeRepository;

    @GetMapping("/planoIncluiModalidade")
    public ResponseEntity<List<PlanoIncluiModalidadeModel>> getAllPlanoIncluiModalidades(){
        return ResponseEntity.status(HttpStatus.OK).body(planoIncluiModalidadeRepository.findAll());
    }

    @GetMapping("/planoIncluiModalidade/{plano_id_plano}/{modalidade_id_modalidade}")
    public ResponseEntity<Object> getOnePlanoIncluiModalidade(@PathVariable(value="plano_id_plano") Integer plano_id_plano,
                                                              @PathVariable(value="modalidade_id_modalidade") Integer modalidade_id_modalidade){

        PlanoIncluiModalidadeId id = new PlanoIncluiModalidadeId();
        id.setPlano_id_plano(plano_id_plano) ;
        id.setModalidade_id_modalidade(modalidade_id_modalidade);

        Optional<PlanoIncluiModalidadeModel> planoIncluiModalidadeO = planoIncluiModalidadeRepository.findById(id);
        if(planoIncluiModalidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O plano não inclui a modalidade.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(planoIncluiModalidadeO.get());
    }

    @PostMapping("/planoIncluiModalidade")
    public ResponseEntity<Object> savePlanoIncluiModalidade(@RequestBody @Valid PlanoIncluiModalidadeRecordDto planoIncluiModalidadeRecordDto) {

        PlanoIncluiModalidadeId id = new PlanoIncluiModalidadeId();
        id.setPlano_id_plano(planoIncluiModalidadeRecordDto.plano_id_plano()); ;
        id.setModalidade_id_modalidade(planoIncluiModalidadeRecordDto.modalidade_id_modalidade());

        Optional<PlanoIncluiModalidadeModel> planoJaIncluiModalide = planoIncluiModalidadeRepository.findById(id);

        if (planoJaIncluiModalide.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O plano já inclui a modalidade.");
        }

        var planoIncluiModalidadeModel = new PlanoIncluiModalidadeModel();
        planoIncluiModalidadeModel.setId(id);
        BeanUtils.copyProperties(planoIncluiModalidadeRecordDto, planoIncluiModalidadeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(planoIncluiModalidadeRepository.save(planoIncluiModalidadeModel));
    }

    @PutMapping("/planoIncluiModalidade/{plano_id_plano}/{modalidade_id_modalidade}")
    public ResponseEntity<Object> updatePlanoIncluiModalidade(@PathVariable(value="plano_id_plano") Integer plano_id_plano,
                                                              @PathVariable(value="modalidade_id_modalidade") Integer modalidade_id_modalidade,
                                                              @RequestBody @Valid PlanoIncluiModalidadeRecordDto planoIncluiModalidadeRecordDto){

        PlanoIncluiModalidadeId id = new PlanoIncluiModalidadeId();
        id.setPlano_id_plano(plano_id_plano) ;
        id.setModalidade_id_modalidade(modalidade_id_modalidade);

        Optional<PlanoIncluiModalidadeModel> planoIncluiModalidadeO = planoIncluiModalidadeRepository.findById(id);
        if(planoIncluiModalidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O plano não inclui a modalidade.");
        }

        var planoIncluiModalidadeModel = planoIncluiModalidadeO.get();

        planoIncluiModalidadeRepository.delete(planoIncluiModalidadeO.get());

        id.setPlano_id_plano(planoIncluiModalidadeRecordDto.plano_id_plano()) ;
        id.setModalidade_id_modalidade(planoIncluiModalidadeRecordDto.modalidade_id_modalidade());

        planoIncluiModalidadeModel.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(planoIncluiModalidadeRepository.save(planoIncluiModalidadeModel));
    }

    @DeleteMapping("/planoIncluiModalidade/{plano_id_plano}/{modalidade_id_modalidade}")
    public ResponseEntity<Object> deletePlanoIncluiModalidade(@PathVariable(value="plano_id_plano") Integer plano_id_plano,
                                                              @PathVariable(value="modalidade_id_modalidade") Integer modalidade_id_modalidade){

        PlanoIncluiModalidadeId id = new PlanoIncluiModalidadeId();
        id.setPlano_id_plano(plano_id_plano) ;
        id.setModalidade_id_modalidade(modalidade_id_modalidade);

        Optional<PlanoIncluiModalidadeModel> planoIncluiModalidadeO = planoIncluiModalidadeRepository.findById(id);
        if(planoIncluiModalidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O plano não inclui a modalidade.");
        }
        planoIncluiModalidadeRepository.delete(planoIncluiModalidadeO.get());
        return ResponseEntity.status(HttpStatus.OK).body("A modalidade foi deletada do plano.");
    }
}
