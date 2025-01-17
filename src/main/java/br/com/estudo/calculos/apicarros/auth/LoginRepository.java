package br.com.estudo.calculos.apicarros.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUsername(String login);

}
