package com.example.loja.controller;

import com.example.loja.dto.CarrinhoDTO;
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
    public void adicionar(@RequestBody CarrinhoDTO carrinho){
        carrinhoService.adicionar(carrinho);
    }

    @ResponseBody
    @DeleteMapping(value = "carrinho/{idcarrinho}/remover/{idproduto}")
    public void remover(@PathVariable("idcarrinho") Long idCarrinho, @PathVariable("idproduto") Long idProduto) throws Exception {
        carrinhoService.remover(idCarrinho, idProduto);
    }

    @ResponseBody
    @GetMapping(value = "carrinho/{id}")
    public ResponseEntity<CarrinhoDTO> carrinhoPorId(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(carrinhoService.carrinhoPorId(id), HttpStatus.OK);
    }
}
