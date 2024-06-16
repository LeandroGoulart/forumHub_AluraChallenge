package com.goulart.forumHub_AluraChallenge.dto;

import com.goulart.forumHub_AluraChallenge.Topico.Topico;

import java.time.LocalDate;

public record DadosListaTopico(String titulo, String mensagem, String nomeAutor, String email_autor, LocalDate data_criacao, String estadoDoTopico, String curso) {

    public DadosListaTopico (Topico topico){
        this(   topico.getTitulo(),
                topico.getMensagem(),
                topico.getNomeAutor(),
                topico.getEmailAutor(),
                topico.getDataDeCriacao(),
                topico.getEstadoDoTopico(),
                topico.getCurso());
    }
}
