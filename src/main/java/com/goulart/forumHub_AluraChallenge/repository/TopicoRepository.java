package com.goulart.forumHub_AluraChallenge.repository;

import com.goulart.forumHub_AluraChallenge.Topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByTituloAndNomeAutor(String titulo, String nomeAutor);

}