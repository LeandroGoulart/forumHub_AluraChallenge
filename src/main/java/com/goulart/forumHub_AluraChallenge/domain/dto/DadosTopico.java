package com.goulart.forumHub_AluraChallenge.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,


        LocalDate data_criacao,

        @NotBlank
        String estadoDoTopico,

        @NotBlank
        String nome_autor,

        @NotBlank
        @Email
        String email_autor,

        @NotBlank
        String curso ) {


}

