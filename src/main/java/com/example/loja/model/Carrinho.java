package com.example.loja.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seq_carrinho" , sequenceName = "seq_carrinho", allocationSize = 1)
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carrinho")
    @Column(name = "ID_CARRINHO")
    private Long id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_PRODUTOS_CARRINHO",
            joinColumns = @JoinColumn(name = "ID_CARRINHO", referencedColumnName = "ID_CARRINHO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUTOS",referencedColumnName = "ID_PRODUTOS")
    )
    private List<Produto> produtos;

}
