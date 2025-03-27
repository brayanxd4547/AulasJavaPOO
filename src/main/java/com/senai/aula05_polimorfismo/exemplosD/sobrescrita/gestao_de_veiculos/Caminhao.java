package com.senai.aula05_polimorfismo.exemplosD.sobrescrita.gestao_de_veiculos;

public class Caminhao extends Veiculo{
    public Caminhao(String modelo) {
        super(modelo);
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Verificação dos freios realizada pelo caminhão " + getModelo());
    }
}
