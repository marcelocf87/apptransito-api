package com.marcelocf87.apptransito.api.controller;

import com.marcelocf87.apptransito.domain.model.Proprietario;
import com.marcelocf87.apptransito.domain.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

   @Autowired
   private ProprietarioRepository proprietarioRepository;

    @GetMapping
    public List<Proprietario> listar() {
//        return proprietarioRepository.findByNomeContaining("Maria");
        return proprietarioRepository.findAll();
    }

    @GetMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> buscar(@PathVariable Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
