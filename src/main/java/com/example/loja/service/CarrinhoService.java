package com.example.loja.service;

import com.example.loja.model.Carrinho;
import com.example.loja.model.Produto;

public interface CarrinhoService {

    void adicionar(Carrinho carrinho);

    void atualizar(Carrinho carrinho, Long id);

    Carrinho carrinhoPorId(Long id) throws Exception;
}
