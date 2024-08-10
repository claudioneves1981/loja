package com.example.loja.adapter;

import com.example.loja.dto.CarrinhoDTO;
import com.example.loja.dto.ProdutoDTO;
import com.example.loja.model.Carrinho;
import com.example.loja.model.Produto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CarrinhoDTOAdapter {

    private CarrinhoDTO carrinhoDTO;

    public CarrinhoDTOAdapter(Carrinho carrinho) {
        carrinhoDTO = toDTO(carrinho);
    }

    private CarrinhoDTO toDTO(Carrinho carrinho){

       List<Produto> produtoList = carrinho.getProdutos();
       List<ProdutoDTO> produtoDTOList = new ArrayList<>();
       for (Produto p : produtoList){
           ProdutoDTO produtoDTO = ProdutoDTO.builder()
                           .id(p.getId())
                           .preco(p.getPreco())
                           .nome(p.getNome())
                           .descricao(p.getDescricao())
                           .build();
           produtoDTOList.add(produtoDTO);
       }

        return CarrinhoDTO.builder()
                .id(carrinho.getId())
                .produtos(produtoDTOList)
                .build();

    }
}
