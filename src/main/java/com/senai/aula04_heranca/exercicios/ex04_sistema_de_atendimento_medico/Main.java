package com.senai.aula04_heranca.exercicios.ex04_sistema_de_atendimento_medico;

public class Main {
    public static void main(String[] args) {
        testarPaciente(new PacienteParticular("Cleber", 50, 300));
        testarPaciente(new PacienteConvenio("Dionísio", 60, 400, 150.0));
    }

    public static void testarPaciente(Paciente paciente){
        System.out.println("Valor total da consulta de " + paciente.getNome() + ": " + paciente.calcularValorTotal());
    }
}
