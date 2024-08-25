package br.com.estudo.calculos.apicarros.service;

import br.com.estudo.calculos.apicarros.model.Carro;
import br.com.estudo.calculos.apicarros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listar() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return carroRepository.findAll(sort );
    }

    public Carro listarById (long id) {

        Optional<Carro> optional = this.carroRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }else
            return null;

    }

    public String salvar (Carro carro) {
        this.carroRepository.save(carro);
        return "Carro cadastrado com sucesso";
    }

    public String atualizar (Carro carro, long id) {
        carro.setId(id);
        this.carroRepository.save(carro);
        return "Atualizado com sucesso";
    }

    public String deletar(Long id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
            return "Carro deletado com sucesso";
        } else {
            return"Carro não encontrado para deletar";
        }
    }
}
