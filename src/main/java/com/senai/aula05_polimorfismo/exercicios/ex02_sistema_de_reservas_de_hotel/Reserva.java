package com.senai.aula05_polimorfismo.exercicios.ex02_sistema_de_reservas_de_hotel;

public class Reserva {
    private String cliente;
    private double custoOriginal;

    public Reserva(String cliente, double custoTotal) {
        this.cliente = cliente;
        this.custoOriginal = custoTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getCustoOriginal() {
        return custoOriginal;
    }

    public void setCustoOriginal(double custoOriginal) {
        this.custoOriginal = custoOriginal;
    }

    public void exibirInformacoes() {
        System.out.printf("""
                 | Cliente da sensor: %s
                 | Custo original: R$%,.2f
                """, cliente, custoOriginal);
    }
}
