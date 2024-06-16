package com.goulart.forumHub_AluraChallenge.dto;

import com.goulart.forumHub_AluraChallenge.Topico.Topico;

public record DadosListaTopico(String titulo, String mensagem, String nomeAutor, String estadoDoTopico, String curso) {

    public DadosListaTopico (Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getNomeAutor(), topico.getEstadoDoTopico(), topico.getCurso());
    }
}
