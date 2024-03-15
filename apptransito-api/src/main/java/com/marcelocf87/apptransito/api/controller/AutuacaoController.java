package com.marcelocf87.apptransito.api.controller;

import com.marcelocf87.apptransito.api.assembler.AutuacaoAssembler;
import com.marcelocf87.apptransito.api.model.AutuacaoModel;
import com.marcelocf87.apptransito.api.model.input.AutuacaoInput;
import com.marcelocf87.apptransito.domain.model.Autuacao;
import com.marcelocf87.apptransito.domain.service.RegistroAutuacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private final AutuacaoAssembler autuacaoAssembler;
    private final RegistroAutuacaoService registroAutuacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@PathVariable Long veiculoId, @Valid @RequestBody AutuacaoInput autuacaoInput) {
        Autuacao novaAutuacao = autuacaoAssembler.toEntity(autuacaoInput);
        Autuacao autuacaoRegistrada = registroAutuacaoService.registrar(veiculoId, novaAutuacao);

        return autuacaoAssembler.toModel(autuacaoRegistrada);

    }

}
