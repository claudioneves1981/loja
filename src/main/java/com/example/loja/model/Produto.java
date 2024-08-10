package com.example.loja.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "seq_produto" , sequenceName = "seq_produto", allocationSize = 1)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    @Column(name = "ID_PRODUTOS")
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "ID_CARRINHO")
    private Carrinho carrinho;

}
