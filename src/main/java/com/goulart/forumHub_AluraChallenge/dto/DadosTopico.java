package com.goulart.forumHub_AluraChallenge.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosTopico(

        @NotBlank
        @Valid
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
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

