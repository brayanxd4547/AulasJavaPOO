package com.senai.aula03_encapsulamento.exemplos.carro;

public class Main {
    public static void main(String[] args) {
        // Criando um objeto da classe Carro
        Carro meuCarro = new Carro();

        // Utilizando métodos públicos para modificar e acessar a variável privada
        meuCarro.setVelocidade(100);
        System.out.println("Velocidade atual: " + meuCarro.getVelocidade());

        // Testando uma velocidade inválida
        // meuCarro.setVelocidade(-20); // Isso mostrará uma mensagem de erro
        meuCarro.velocidade = -20; // Agora funcionará sem erro
        System.out.println("Velocidade modificada diretamente: " + meuCarro.getVelocidade());
    }
}
