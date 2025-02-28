package com.senai.aula03_encapsulamento.exemplos.carro;

public class Carro {
    // Atributo privado: só pode ser acessado dentro da própria classe
    public int velocidade;

    // Construtor da classe
    public Carro() {
        velocidade = 0; // Inicialmente o carro está parado
    }

    // Metodo público para obter a velocidade (Getter)
    public int getVelocidade(){
        return  velocidade;
    }

    // Metodo público para definir a velocidade (Setter)
    public void setVelocidade(int velocidade){
        if (velocidade >= 0) {
            this.velocidade = velocidade;
        } else {
            System.out.println("Velocidade inválida!");
        }
    }
}
