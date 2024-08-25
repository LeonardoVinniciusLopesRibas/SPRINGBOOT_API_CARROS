package br.com.estudo.calculos.apicarros.controller;

import br.com.estudo.calculos.apicarros.model.Carro;
import br.com.estudo.calculos.apicarros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Carro>> listar() {
        return ResponseEntity.ok(carroService.listar());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Carro> listar(@PathVariable long id){
        try {
            Carro carro = this.carroService.listarById(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Carro carro){
        try {
            String mensagem = this.carroService.salvar(carro);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Carro carro, @PathVariable long id){
        try {
            String mensagem = this.carroService.atualizar(carro, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id){

        try {

            String mensagem = this.carroService.deletar(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
