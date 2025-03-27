package com.senai.aula05_polimorfismo.exemplosD.sobrescrita.animal;

public class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("O cachorro faz: Au au!");
    }
}
