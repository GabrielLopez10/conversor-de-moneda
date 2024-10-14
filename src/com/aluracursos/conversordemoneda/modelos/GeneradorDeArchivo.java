package com.aluracursos.conversordemoneda.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(TipoDeCambio tipoDeCambio) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escritura = new FileWriter(tipoDeCambio.monedaBase() +
                "-" +
                tipoDeCambio.monedaDestino() +
                ".json")) {

            gson.toJson(tipoDeCambio, escritura);
        }
    }
}
