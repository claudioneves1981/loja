package com.example.loja.controller;

import com.example.loja.dto.VendaDTO;
import com.example.loja.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping(value = "carrinho/{id}/precototal")
    public ResponseEntity<VendaDTO> totalPreco(@PathVariable("id") Long id) throws Exception {
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setPrecoTotal(String.format("%.2f",vendaService.totalPreco(id)));
        return new ResponseEntity<>(vendaDTO, HttpStatus.OK);
    }

}
