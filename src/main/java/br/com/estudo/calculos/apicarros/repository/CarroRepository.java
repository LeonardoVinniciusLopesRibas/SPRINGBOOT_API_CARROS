package br.com.estudo.calculos.apicarros.repository;

import br.com.estudo.calculos.apicarros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
