package com.senai.aula01_introducao_poo.exemplos.concessionaria;

public class Main {
    public static void main(String[] args) {
        // Construindo objeto "pessoa1" da classe "Pessoa"
        Carro carro1 = new Carro(
                "HB20",
                "branco",
                150f,
                false,
                "Hyundai",
                14678.2f,
                2020,
                50200.00f
        );

        Carro carro2 = new Carro(
                "Gol",
                "preto",
                120f,
                false,
                "Wolkswagen",
                23213.4f,
                2012,
                34200.0f
        );

        System.out.println(carro1);
        System.out.println(carro2);

        System.out.println("Quilometragem antes do test drive para o " + carro1.modelo + " " + carro1.cor + ": " + carro1.quilometragem + "km");
        carro1.testDrive(30.0f);
        System.out.println("Quilometragem depois do test drive para o " + carro1.modelo + " " + carro1.cor + ": " + carro1.quilometragem + "km");
        System.out.println();

        System.out.println("Quilometragem antes do test drive para o " + carro2.modelo + " " + carro2.cor + ": " + carro2.quilometragem + "km");
        carro2.testDrive(30.0f);
        System.out.println("Quilometragem depois do test drive para o " + carro2.modelo + " " + carro2.cor + ": " + carro2.quilometragem + "km");
        System.out.println();

        carro1.comprar("Miguel F. Menghui");
        System.out.println();

        carro2.valorTabelaFlip(2030);
    }
}
