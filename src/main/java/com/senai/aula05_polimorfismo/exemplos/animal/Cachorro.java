package com.senai.aula05_polimorfismo.exemplos.animal;

public class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("O cachorro faz: Au au!");
    }
}
