package com.goulart.forumHub_AluraChallenge.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopico(

        String emailAutor,

        @NotBlank
        String mensagem,

        String curso)
{


}
