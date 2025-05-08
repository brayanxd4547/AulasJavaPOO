package com.senai.aula07_mvc.crud_usuario.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OperadorDAO {
    private List<Operador> operadores;
    private final String FILE_PATH = "operadores.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<Operador> carregar() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Operador>>() {
            }.getType(); // Indica o tipo de lista para o GSON
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>(); // Retorna uma lista vazia caso não haja dados
        }
    }

    public OperadorDAO() {
        operadores = carregar();
    }

    public void salvar(Operador operador) {
        operadores.add(operador);
        salvarJson();
    }

    public void salvarJson() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(operadores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Operador> listar() {
        return operadores;
    }

    // Estratégia forEach: altera cada elemento da lista usando diretamente a função lambda
    public void atualizar(Operador operador) {
        operadores.forEach(o -> {
            if (o.getId() == operador.getId()) {
                o.setNome(operador.getNome());
                o.setSetor(operador.getNome());
            }
        });
    }

    // Estratégia Iterator: usa um iterador para alterar os elementos da lista
    public boolean deletar(int id){
        Iterator<Operador> iterator = operadores.iterator();
        while (iterator.hasNext()) {
            Operador o = iterator.next();

            if(o.getId() == id) {
                iterator.remove();
                salvarJson();
                return true;
            }
        }
        return false;
    }
}
