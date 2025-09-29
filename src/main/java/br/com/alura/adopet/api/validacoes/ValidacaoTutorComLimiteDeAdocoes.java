package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidacaoTutorComLimiteDeAdocoes implements ValidacaoSolicitacaoAdocao {
    @Autowired
    AdocaoRepository repository;

    public void validar(SolicitacaoAdocaoDto dto) {
        Integer adocoesTutor = repository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);

        if (adocoesTutor == 5) {
            throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
        }
    }
}
