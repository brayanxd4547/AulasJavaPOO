package com.senai.aula04_herancaD.exemplos.sistema_de_cadastro_de_funcionarios;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario00 = new Funcionario("Carlos", 3000);
        funcionario00.exibirInformacoes();

        Gerente gerente00 = new Gerente("Eduardo", 3000, 1000);
        gerente00.exibirInformacoes();
    }
}
