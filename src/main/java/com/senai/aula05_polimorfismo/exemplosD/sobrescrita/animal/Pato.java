package com.senai.aula05_polimorfismo.exemplosD.sobrescrita.animal;

public class Pato extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("O pato faz: Quack quack!");
    }

    public void voar(){
        System.out.println("O pato voou e nunca mais voltou...");
    }
}
