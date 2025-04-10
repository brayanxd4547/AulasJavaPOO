package com.senai.aula04_herancaD.exercicios.ex02_sistema_de_funcionarios;

import java.util.List;

public class Coordenador extends Funcionario {
    private List<Professor> equipeProfessores;

    public Coordenador(String nome, double salario, List<Professor> equipeProfessores) {
        super(nome, salario);
        this.equipeProfessores = equipeProfessores;
    }

    public List<Professor> getEquipeProfessores() {
        return equipeProfessores;
    }

    public void setEquipeProfessores(List<Professor> equipeProfessores) {
        this.equipeProfessores = equipeProfessores;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.print(" | Equipe de professores: ");
        equipeProfessores.forEach(p -> System.out.print(p.getNome() + ", "));
    }
}
