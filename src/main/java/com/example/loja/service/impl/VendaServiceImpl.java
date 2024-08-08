package com.example.loja.service.impl;

import com.example.loja.model.Carrinho;
import com.example.loja.model.Produto;
import com.example.loja.repository.CarrinhoRepository;
import com.example.loja.repository.ProdutoRepository;
import com.example.loja.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;


    @Override
    public Double totalPreco(Long id) {
       Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
       List<Produto> produtos = carrinho.get().getProdutos();
       double totalPreco = 0d;
        for (Produto produto : produtos) {
            totalPreco += produto.getPreco();

        }
        return totalPreco;
    }
}
