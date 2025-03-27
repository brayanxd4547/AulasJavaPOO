package com.senai.aula05_polimorfismo.exemplosD.sobrescrita.animal;

public class Main {
    public static void main(String[] args) {
        //testarAnimal(new Cachorro());
        testarAnimal(new Pato());
        testarAnimal(new Animal());
    }

    // Polimorfismo: mesmo metodo possui comportamento diferente dependendo da instância
    public static void testarAnimal(Animal animal){
        animal.fazerSom();
        Pato pato = (Pato) animal;
        pato.voar();
    }
}
