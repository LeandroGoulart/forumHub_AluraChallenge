package com.goulart.forumHub_AluraChallenge.Topico;

import com.goulart.forumHub_AluraChallenge.dto.DadosAtualizacaoTopico;
import com.goulart.forumHub_AluraChallenge.dto.DadosTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDate dataDeCriacao = LocalDate.now();

    private String estadoDoTopico;

    private String nomeAutor;

    @Column(name = "email_autor")
    private String emailAutor;

    private String curso;


    public Topico(DadosTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataDeCriacao = (dados.data_criacao() != null) ? dados.data_criacao() : LocalDate.now();
        this.estadoDoTopico = dados.estadoDoTopico();
        this.nomeAutor = dados.nome_autor();
        this.emailAutor = dados.email_autor();
        this.curso = dados.curso();
    }


    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {

        if (dados.emailAutor() != null) {
            this.emailAutor = dados.emailAutor();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }

    }
}