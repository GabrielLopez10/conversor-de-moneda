package com.aluracursos.conversordemoneda.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void guardarJson(TipoDeCambio nuevaConversion) throws IOException {
        String nombreArchivo = nuevaConversion.monedaBase() + "-" + nuevaConversion.monedaDestino() + ".json";

        List<TipoDeCambio> conversiones = cargarConversacionesExistentes(nombreArchivo);

        conversiones.add(nuevaConversion);

        try (Writer escritura = new FileWriter(nombreArchivo)){
            gson.toJson(conversiones, escritura);
        }

        System.out.println("Datos guardados en el archivo: " + nombreArchivo);
    }

    private List<TipoDeCambio> cargarConversacionesExistentes(String nombreArchivo) {
        List<TipoDeCambio> conversaciones = new ArrayList<>();

        try (FileReader lectura = new FileReader(nombreArchivo)){
            Type tipoLista = new TypeToken<List<TipoDeCambio>>() {
            }.getType();
            conversaciones = gson.fromJson(lectura, tipoLista);
        } catch (IOException e) {
            System.out.println("No se encontro el archivo " +
                    "" + nombreArchivo + ", se está creando uno nuevo.");
        }
        return conversaciones;
    }
}