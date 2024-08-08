package com.example.loja.controller;

import com.example.loja.model.Carrinho;
import com.example.loja.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @ResponseBody
    @PostMapping(value = "carrinho/adicionar")
    public void adicionar(@RequestBody Carrinho carrinho){
        carrinhoService.adicionar(carrinho);
    }

    @ResponseBody
    @PutMapping(value = "carrinho/{id}/atualizar")
    public void atualizar(@RequestBody Carrinho carrinho, @PathVariable("id") Long id){
        carrinhoService.atualizar(carrinho, id);
    }

    @ResponseBody
    @GetMapping(value = "carrinho/{id}")
    public ResponseEntity<Carrinho> carrinhoPorId(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(carrinhoService.carrinhoPorId(id), HttpStatus.OK);
    }
}
