package com.senai.aula04_heranca.exercicios.ex02_sistema_de_funcionarios;

import java.util.ArrayList;

public class Coordenador extends Funcionario {
    private ArrayList<Professor> equipeProfessores = new ArrayList<>();

    public Coordenador(String nome, double salario, ArrayList<Professor> equipeProfessores) {
        super(nome, salario);
        this.equipeProfessores = equipeProfessores;
    }

    public ArrayList<Professor> getEquipeProfessores() {
        return equipeProfessores;
    }

    public void setEquipeProfessores(ArrayList<Professor> equipeProfessores) {
        this.equipeProfessores = equipeProfessores;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.print(" | Equipe de professores: ");
        equipeProfessores.forEach(p -> System.out.print(p.getNome() + ", "));
    }
}
