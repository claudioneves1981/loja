package com.example.loja.service.impl;

import com.example.loja.model.Carrinho;
import com.example.loja.model.Produto;
import com.example.loja.repository.CarrinhoRepository;
import com.example.loja.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Override
    public void adicionar(Carrinho carrinho) {
        carrinhoRepository.save(carrinho);
    }

    @Override
    public void atualizar(Carrinho carrinho, Long id) {
        Optional<Carrinho> optionalCarrinho = carrinhoRepository.findById(id);
        if(optionalCarrinho.isPresent()){
            carrinhoRepository.save(carrinho);
        }
    }

    @Override
    public Carrinho carrinhoPorId(Long id) throws Exception {
        return carrinhoRepository.findById(id).orElseThrow(() -> new Exception("Carrinho não encontrado"));
    }
}
