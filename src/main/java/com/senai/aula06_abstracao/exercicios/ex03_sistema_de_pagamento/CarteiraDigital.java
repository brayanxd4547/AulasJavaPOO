package com.senai.aula06_abstracao.exercicios.ex03_sistema_de_pagamento;

public class CarteiraDigital extends FormaDePagamento{
    public CarteiraDigital(String usuario, String destinatario, double valor) {
        super(usuario, destinatario, valor);
    }

    public void inserirDadosCarteira(){
        System.out.println(" * Inserindo dados da carteira digital:");
        System.out.printf("""
                 | CPF: 301.395.294-11
                 | Usuário: %s
                """, usuario);
    }

    @Override
    void autenticarUsuario() {
        System.out.printf("Autenticando carteira digital de %s no sistema...\n", usuario);
        System.out.printf("Carteira digital autenticado! Bem-vindo, %s\n", usuario);
    }

    @Override
    void validacaoAntifraude() {
        System.out.println(" * Protocolo de verificação de fraude da transação por carteira digital.");
        System.out.printf(" | REMETENTE: %s validado.\n", usuario);
        System.out.printf(" | DESTINATÁRIO: %s validado.\n", destinatario);
    }

    @Override
    void registrarTransacao() {
        System.out.println("A transação financeira por carteira digital foi realizada com sucesso.");
    }
}
