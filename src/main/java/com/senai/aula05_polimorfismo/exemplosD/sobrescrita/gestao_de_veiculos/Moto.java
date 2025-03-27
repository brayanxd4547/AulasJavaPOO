package com.senai.aula05_polimorfismo.exemplosD.sobrescrita.gestao_de_veiculos;

public class Moto extends Veiculo{
    public Moto(String modelo) {
        super(modelo);
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Troca de óleo realizada para a moto " + getModelo());
    }
}
