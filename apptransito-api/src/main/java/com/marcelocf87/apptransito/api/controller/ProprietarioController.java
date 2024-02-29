package com.marcelocf87.apptransito.api.controller;

import com.marcelocf87.apptransito.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("/proprietarios")
    public List<Proprietario> lisar() {
        var proprietario1 = new Proprietario();
        proprietario1.setId(1L);
        proprietario1.setNome("João Batista");
        proprietario1.setTelefone("99 99999-9999");
        proprietario1.setEmail("proprietario1@gmail.com");

        var proprietario2 = new Proprietario();
        proprietario2.setId(2L);
        proprietario2.setNome("Maria de Fátima");
        proprietario2.setTelefone("99 99999-9999");
        proprietario2.setEmail("proprietario2@gmail.com");

        return Arrays.asList(proprietario1, proprietario2);

    }
}
