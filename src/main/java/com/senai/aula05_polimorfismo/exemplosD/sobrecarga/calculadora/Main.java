package com.senai.aula05_polimorfismo.exemplosD.sobrecarga.calculadora;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        calc.somar(5,1);
        calc.somar(3,4,5);
        calc.somar(1.3,5.33);
        calc.somar(5,34.5);
        calc.somar(599.3,13);
    }
}
