package com.goulart.forumHub_AluraChallenge.infra.security;

import com.goulart.forumHub_AluraChallenge.domain.repository.UsuarioRepository;
import com.goulart.forumHub_AluraChallenge.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    //Utiliza token recuperado do header da requisição para validação
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
                throws ServletException, IOException {

        var tokenGerado = recuperToken(request);

        if (tokenGerado != null) {
            var subject = tokenService.getSubject(tokenGerado);
            var usuario = repository.findByLogin(subject);
            //Cria autenticação - considera logado
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        //System.out.println("usuario: " + subject + " Token gerado: " + tokenGerado);

        filterChain.doFilter(request, response);
    }

    //Recupera token do header da requisição
    private String recuperToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

}
