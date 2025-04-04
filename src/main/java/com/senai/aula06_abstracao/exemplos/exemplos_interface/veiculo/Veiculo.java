package com.senai.aula06_abstracao.exemplos.exemplos_interface.veiculo;

public interface Veiculo {
    void acelerar();

    default void buzinar() {
        System.out.println("Bi bi!");
    }
}
