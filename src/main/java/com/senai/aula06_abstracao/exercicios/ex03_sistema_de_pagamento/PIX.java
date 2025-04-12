package com.senai.aula06_abstracao.exercicios.ex03_sistema_de_pagamento;

public class PIX extends FormaDePagamento {
    public PIX(String usuario, String destinatario, double valor) {
        super(usuario, destinatario, valor);
    }

    public void inserirChavePIX(){
        System.out.println(" * Inserindo a chave PIX:");
        System.out.printf("""
                 | Chave PIX: 693.028.194-35
                 | Usuário: %s
                """, usuario);
    }

    @Override
    void autenticarUsuario() {
        System.out.printf("Autenticando conta PIX de %s no sistema...\n", usuario);
        System.out.printf("Conta PIX autenticada! Bem-vindo, %s\n", usuario);
    }

    @Override
    void validacaoAntifraude() {
        System.out.println(" * Protocolo de verificação de fraude da transação via PIX.");
        System.out.printf(" | REMETENTE: %s validado.\n", usuario);
        System.out.printf(" | DESTINATÁRIO: %s validado.\n", destinatario);
    }

    @Override
    void registrarTransacao() {
        System.out.println("A transação financeira via PIX foi realizada com sucesso.");
    }
}
