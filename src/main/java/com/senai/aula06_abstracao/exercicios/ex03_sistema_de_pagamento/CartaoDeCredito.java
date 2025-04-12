package com.senai.aula06_abstracao.exercicios.ex03_sistema_de_pagamento;

public class CartaoDeCredito extends FormaDePagamento {
    public CartaoDeCredito(String usuario, String destinatario, double valor) {
        super(usuario, destinatario, valor);
    }

    public void inserirDadosCartao() {
        System.out.println(" * Inserindo os dados do cartão:");
        System.out.printf("""
                 | Número do cartão de crédito: 9800 5027 9430 1504
                 | Data de validade: 12/27
                 | Titular: %s
                """, usuario);
    }

    @Override
    void autenticarUsuario() {
        System.out.printf("Autenticando cartão de crédito de %s no sistema...\n", usuario);
        System.out.printf("Cartão de crédito autenticado! Bem-vindo, %s\n", usuario);
    }

    @Override
    void validacaoAntifraude() {
        System.out.println(" * Protocolo de verificação de fraude da transação por cartão de crédito. * ");
        System.out.printf(" | REMETENTE: %s validado.\n", usuario);
        System.out.printf(" | DESTINATÁRIO: %s validado.\n", destinatario);
    }

    @Override
    void registrarTransacao() {
        System.out.println("A transação financeira por cartão de crédito foi realizada com sucesso.");
    }
}
