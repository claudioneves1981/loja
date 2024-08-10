package com.example.loja.adapter;

import com.example.loja.dto.CarrinhoDTO;
import com.example.loja.dto.ProdutoDTO;
import com.example.loja.model.Carrinho;
import com.example.loja.model.Produto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CarrinhoModelAdapter {

    private Carrinho carrinho;

    public CarrinhoModelAdapter(CarrinhoDTO carrinhoDTO) {
        carrinho = toModel(carrinhoDTO);
    }

    private Carrinho toModel(CarrinhoDTO carrinhoDTO){

       List<ProdutoDTO> produtoDTOList = carrinhoDTO.getProdutos();
       List<Produto> produtoList = new ArrayList<>();
       for (ProdutoDTO p : produtoDTOList){
           Produto produto = Produto.builder()
                           .id(p.getId())
                           .preco(p.getPreco())
                           .nome(p.getNome())
                           .descricao(p.getDescricao())
                           .build();
           produtoList.add(produto);
       }

        return Carrinho.builder()
                .id(carrinhoDTO.getId())
                .produtos(produtoList)
                .build();
    }
}
