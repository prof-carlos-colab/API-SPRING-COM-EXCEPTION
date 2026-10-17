package com.senai.projeto.service;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    // READ - GET - MOSTRAR TODOS OS CLIENTES.
    public List<ClienteEntity> listarTodos() {
        return repository.findAll();
    }

    // INSERT - POST - SALVAR UM CLIENTE.
    public ClienteEntity salvarCliente(ClienteEntity cliente) {
        // VERIFICA SE O E-MAIL DO CLIENTE JÁ ESTÁ NO BANCO DE DADOS
        // ANTES DE SALVAR, PARA EVITAR DUPLICAR.
        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        return repository.save(cliente);
    }

    // UPDATE - PUT - ATUALIZAR DADOS.
    public ClienteEntity atualizarCliente(Long id, ClienteEntity cliente) {
        // VERIFICA SE O CLIENTE ESTÁ CADASTRADO NO BANCO DE DADDOS.
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado.");

        // CASO ESTEJA, OS DADOS SÃO ATUALIZADOS.
        cliente.setId(id);
        return repository.save(cliente);
    }

    // DELETE - DELETE - EXCLUIR CLIENTE.
    public void excluirCliente(Long id) {
        // VERIFICA SE O CLIENTE ESTÁ CADASTRADO NO BANCO DE DADDOS.
        // CASO NÃO ESTEJA, NÃO EXCLIRÁ OS DADOS.
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado.");

        // IRÁ EXCLUIR UM CLIENTE COM ID CADASTRADO.
        repository.deleteById(id);
    }
}
