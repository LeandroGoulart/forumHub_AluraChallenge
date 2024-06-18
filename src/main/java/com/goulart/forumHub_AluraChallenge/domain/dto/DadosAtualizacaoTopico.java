package com.goulart.forumHub_AluraChallenge.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(

        @NotNull
        Long id,

        String emailAutor,

        @NotBlank
        String mensagem,

        String curso)
{


}
