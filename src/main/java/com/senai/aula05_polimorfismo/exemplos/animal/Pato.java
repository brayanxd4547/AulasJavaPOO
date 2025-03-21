package com.senai.aula05_polimorfismo.exemplos.animal;

public class Pato extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("O pato faz: Quack quack!");
    }

    public void voar(){
        System.out.println("O pato voou e nunca mais voltou...");
    }
}
