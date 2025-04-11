package com.senai.aula04_herancaD.exercicios.ex04_sistema_de_atendimento_medico;

public class Main {
    public static void main(String[] args) {
        Paciente paciente1 = new PacienteParticular("Cleber", 50, 300);
        Paciente paciente2 = new PacienteConvenio("Dionísio", 60, 400, 150.0);

        System.out.println("Valor total da consulta de " + paciente1.getNome() + ": " + paciente1.calcularValorTotal());
        System.out.println("Valor total da consulta de " + paciente2.getNome() + ": " + paciente2.calcularValorTotal());
    }
}
