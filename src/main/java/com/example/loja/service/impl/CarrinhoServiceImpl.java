package com.example.loja.service.impl;

import com.example.loja.adapter.CarrinhoDTOAdapter;
import com.example.loja.adapter.CarrinhoModelAdapter;
import com.example.loja.dto.CarrinhoDTO;
import com.example.loja.model.Carrinho;
import com.example.loja.model.Produto;
import com.example.loja.repository.CarrinhoRepository;
import com.example.loja.repository.ProdutoRepository;
import com.example.loja.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void adicionar(CarrinhoDTO carrinhoDTO) {
        Carrinho carrinho = new CarrinhoModelAdapter(carrinhoDTO).getCarrinho();
        carrinhoRepository.save(carrinho);
    }

    @Override
    public void remover(Long idCarrinho, Long idProduto) throws Exception {
       Carrinho carrinho = carrinhoRepository.findById(idCarrinho)
               .orElseThrow(()->  new Exception("Carrinho não encontrado"));
       Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(()->  new Exception("Carrinho não encontrado"));

       carrinho.getProdutos().remove(produto);
       carrinhoRepository.save(carrinho);

    }

    @Override
    public CarrinhoDTO carrinhoPorId(Long id) throws Exception {
        Carrinho carrinho =  carrinhoRepository.findById(id).orElseThrow(() -> new Exception("Carrinho não encontrado"));
        return new CarrinhoDTOAdapter(carrinho).getCarrinhoDTO();
    }
}
