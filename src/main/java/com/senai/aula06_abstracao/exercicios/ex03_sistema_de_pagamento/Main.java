package com.senai.aula06_abstracao.exercicios.ex03_sistema_de_pagamento;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        FormaDePagamento transacao1 = new CartaoDeCredito("Paulo Costa Menezes", "Joana Castela Prado", 200);
        FormaDePagamento transacao2 = new PIX("Joana Castela Prado", "Guilherme Henrique Souza", 200);
        FormaDePagamento transacao3 = new CarteiraDigital("Guilherme Henrique Souza", "Maria Dolores Tereza Nascimento", 150);

        testeFormaDePagamento(transacao1, LocalTime.of(13,44,48));
        testeFormaDePagamento(transacao2, LocalTime.of(13,58,32));
        testeFormaDePagamento(transacao3, LocalTime.of(14, 0,45));
    }

    public static void testeFormaDePagamento(FormaDePagamento formaDePagamento, LocalTime horario){
        System.out.println();
        FormaDePagamento.exibirMensagemPadrao();

        formaDePagamento.autenticarUsuario();

        // Comportamento específico para cada classe

        // Ideia original
        /*
        if (formaDePagamento instanceof CartaoDeCredito cartaoDeCredito) {
            cartaoDeCredito.inserirDadosCartao();
        } else if (formaDePagamento instanceof PIX pix) {
            pix.inserirChavePIX();
        } else if (formaDePagamento instanceof CarteiraDigital carteiraDigital) {
            carteiraDigital.inserirDadosCarteira();
        }
         */

        // Ideia recomendada pelo IntelliJ
        switch (formaDePagamento) {
            case CartaoDeCredito cartaoDeCredito -> cartaoDeCredito.inserirDadosCartao();
            case PIX pix -> pix.inserirChavePIX();
            case CarteiraDigital carteiraDigital -> carteiraDigital.inserirDadosCarteira();
            default -> {
            }
        }

        formaDePagamento.validacaoAntifraude();
        formaDePagamento.validacaoDeSeguranca();

        formaDePagamento.registrarLogs(horario);
        formaDePagamento.registrarTransacao();
    }
}
