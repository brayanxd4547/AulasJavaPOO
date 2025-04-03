package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.animal;

public class Pato extends Animal{
    public Pato(String nome) {
        super(nome);
    }

    void botarOvo(){
        System.out.println("Parabéns, a pata " + nome + " virou mamãe!");
    }

    @Override
    void fazerSom() {
        System.out.println("O pato faz: quack quack!");
    }
}
