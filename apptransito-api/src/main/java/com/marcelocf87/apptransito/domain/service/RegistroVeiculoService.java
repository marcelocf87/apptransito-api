package com.marcelocf87.apptransito.domain.service;

import com.marcelocf87.apptransito.domain.exception.NegocioException;
import com.marcelocf87.apptransito.domain.model.Proprietario;
import com.marcelocf87.apptransito.domain.model.StatusVeiculo;
import com.marcelocf87.apptransito.domain.model.Veiculo;
import com.marcelocf87.apptransito.domain.repository.ProprietarioRepository;
import com.marcelocf87.apptransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final RegistroProprietarioService registroProprietarioService;

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {
        if (novoVeiculo.getId() != null) {
            throw new NegocioException("Veículo a ser cadastrado não deve possuir um ID");
        }

        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca()).filter(veiculo -> !veiculo.equals(novoVeiculo)).isPresent();

        if (placaEmUso) {
            throw new NegocioException("Já existe um veículo cadastrado com esta placa");
        }

        Proprietario proprietario = registroProprietarioService.buscar(novoVeiculo.getProprietario().getId());

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus((StatusVeiculo.REGULAR));
        novoVeiculo.setDataCadastro(OffsetDateTime.now());

        return veiculoRepository.save((novoVeiculo));
    }
}
