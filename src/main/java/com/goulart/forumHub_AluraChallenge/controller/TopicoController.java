package com.goulart.forumHub_AluraChallenge.controller;

import com.goulart.forumHub_AluraChallenge.dto.DadosListaTopico;
import com.goulart.forumHub_AluraChallenge.Topico.Topico;
import com.goulart.forumHub_AluraChallenge.dto.DadosTopico;
import com.goulart.forumHub_AluraChallenge.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<String> cadastrartopico(@RequestBody @Valid DadosTopico dados) {

        Optional<Topico> topicoExistente = repository.findByTituloAndNomeAutor(dados.titulo(), dados.nome_autor());

        if (topicoExistente.isPresent()) {
            return new ResponseEntity<>("Tópico já existe com o mesmo título e autor", HttpStatus.BAD_REQUEST);
        }

        Topico topico = new Topico(dados);
        repository.save(topico);

        return new ResponseEntity<>("Tópico criado com sucesso", HttpStatus.CREATED);
    }

    @GetMapping
    public List<DadosListaTopico> listarTopicos() {
        return repository.findAll().stream().map(DadosListaTopico::new).toList();
    }

}