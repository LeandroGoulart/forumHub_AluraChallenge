package com.goulart.forumHub_AluraChallenge.domain.dto;

import com.goulart.forumHub_AluraChallenge.domain.model.Topico;

public record DadosDetalhamentoTopico(Topico topico, String extraInfo, String titulo, String mensagem, String nomeAutor, String emailAutor, String dataDeCriacao, String estadoDoTopico, String curso) {

    public DadosDetalhamentoTopico(Topico topico, String extraInfo) {
        this(topico, extraInfo, topico.getTitulo(), topico.getMensagem(), topico.getNomeAutor(), topico.getEmailAutor(), topico.getDataDeCriacao().toString(), topico.getEstadoDoTopico(), topico.getCurso());
    }
}