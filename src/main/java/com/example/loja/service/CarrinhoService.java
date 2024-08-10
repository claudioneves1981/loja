package com.example.loja.service;

import com.example.loja.dto.CarrinhoDTO;
import com.example.loja.model.Carrinho;
import com.example.loja.model.Produto;

public interface CarrinhoService {

    void adicionar(CarrinhoDTO carrinho);

    void remover(Long idproduto, Long id) throws Exception;

    CarrinhoDTO carrinhoPorId(Long id) throws Exception;
}
