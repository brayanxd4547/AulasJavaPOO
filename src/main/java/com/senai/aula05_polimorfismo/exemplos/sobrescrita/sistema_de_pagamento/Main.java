package com.senai.aula05_polimorfismo.exemplos.sobrescrita.sistema_de_pagamento;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pagamento> listaPagamentos = new ArrayList<>();
        listaPagamentos.add(new CLT("Rafael Costa", 9000));
        listaPagamentos.add(new PJ("Tércio Ribeiro", 300, 100));
        listaPagamentos.add(new Freelancer("Ricardo Orrico", 9000));
        listaPagamentos.add(new CLT("Roger Gabriel", 9000));

        listaPagamentos.forEach(p ->
                System.out.printf("%s recebe R$%,.2f\n", p.getNome(), p.calcularPagamento())
        );
    }
}
