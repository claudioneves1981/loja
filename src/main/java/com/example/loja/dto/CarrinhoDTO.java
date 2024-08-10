package com.example.loja.dto;

import com.example.loja.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarrinhoDTO {

    private Long id;
    private List<ProdutoDTO> produtos;

}
