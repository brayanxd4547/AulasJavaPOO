package com.senai.aula05_polimorfismo.exercicios.ex02_sistema_de_reservas_de_hotel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste da reserva simples");
        testarReserva(new ReservaSimples("João", 300, 20));

        System.out.println("Teste da reserva VIP");
        testarReserva(new ReservaVIP("Marta", 300, 20));
    }

    public static void testarReserva(Reserva reserva){
        reserva.exibirInformacoes();
    }
}
