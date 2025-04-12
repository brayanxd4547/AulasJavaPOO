package com.senai.aula05_polimorfismo.exercicios.ex05_sistema_de_beneficios_de_funcionarios;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste do desconto salarial de VA");
        testarDesconto(new ValeAlimentacao(30));

        System.out.println("Teste do desconto salarial de plano de saúde");
        testarDesconto(new PlanoDeSaude(100));

        System.out.println("Teste do desconto salarial de VR");
        testarDesconto(new ValeTransporte(40));
    }

    public static void testarDesconto(Beneficio beneficio){
        beneficio.exibirInformacoes();
    }
}
