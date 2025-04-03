package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.animal;

public class Main {
    public static void main(String[] args) {
        testarAnimal(new Cachorro("Rex"));
        testarAnimal(new Pato("Alexandre"));
    }

    public static void testarAnimal(Animal animal){
        animal.dormir();
        animal.fazerSom();
        if(animal instanceof Pato pato){
            pato.botarOvo();
        }
    }
}
