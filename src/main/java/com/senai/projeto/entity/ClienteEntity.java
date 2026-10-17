package com.senai.projeto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // TRANSFORMA ESTA CLASSE EM TABELA NO BANCO DE DADOS.
@Table(name = "tab_cliente") // CRIA A TABELA COM O NOME TAB_CLIENTE.
@NoArgsConstructor // CRIA CONSTRUTOR VAZIO.
@AllArgsConstructor // CRIA CONSTRUTOR COMPLETO.
@Data // CRIA MÉTODS GET E SET.
public class ClienteEntity {
    @Id // DEFINE O CAMPO COMO CHAVE PRIMÁRIA.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENTO.
    private Long id;

    private String nome;
    private String email;
    private String telefone;
}
