package br.com.estudo.calculos.apicarros.repository;

import br.com.estudo.calculos.apicarros.model.Carro;
import br.com.estudo.calculos.apicarros.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{
}
