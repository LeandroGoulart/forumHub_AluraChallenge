package com.goulart.forumHub_AluraChallenge.domain.repository;

import com.goulart.forumHub_AluraChallenge.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);
}
