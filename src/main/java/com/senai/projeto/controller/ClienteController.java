package com.senai.projeto.controller;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteEntity> listar() {
        return service.listarTodos();
    }

    @PostMapping
    ResponseEntity<Map<?, ?>> salvar(@RequestBody ClienteEntity cliente) {
        service.salvarCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteEntity cliente) {

        // O SERVICE VERIFICA SE PODE OU NÃO ATUALIZAR O CLIENTE.
        service.atualizarCliente(id, cliente);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id) {
        // O SERVICE VERIFICA SE PODE OU NÃO EXCLUIR O CLIENTE.
        service.excluirCliente(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente excluído com sucesso."));
    }

}
