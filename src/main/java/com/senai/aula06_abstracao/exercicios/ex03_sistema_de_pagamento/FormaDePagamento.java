package com.senai.aula06_abstracao.exercicios.ex03_sistema_de_pagamento;

import java.time.LocalTime;

public abstract class FormaDePagamento {
    protected String usuario;
    protected String destinatario;
    protected double valor;

    public FormaDePagamento(String usuario, String destinatario, double valor) {
        this.usuario = usuario;
        this.destinatario = destinatario;
        this.valor = valor;
    }

    abstract void autenticarUsuario();
    abstract void validacaoAntifraude();
    abstract void registrarTransacao();

    public static void exibirMensagemPadrao() {
        System.out.println("Sistema de transação incorporado pela FinTechPlus.");
    }

    public void registrarLogs(LocalTime horario) {
        System.out.printf("%s - TRANSAÇÃO SUCEDIDA: Transação de R$%,.2f de %s para %s\n", horario, valor, usuario, destinatario);
    }

    public void validacaoDeSeguranca() {
        System.out.println("Validando segurança da transação...");
        System.out.println("Transação validada pela FinTechPlus.");
    }
}
