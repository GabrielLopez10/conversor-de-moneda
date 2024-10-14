package com.aluracursos.conversordemoneda.modelos;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class ConvertidorMoneda {
    public static TipoDeCambio obtenerTasaDeCambio(String monedaBase, String monedaDestino) {
        try {

            // llama al servicio API
            String jsonResponse = ServicioApi.obtenerDatosCambio(monedaBase, monedaDestino);
            // Parsea la respuesta JSON
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

            //Extrae los datos del JSON
            String convertidoDeMoneda = jsonObject.get("base_code").getAsString();
            String convertidoHaciaMoneda = jsonObject.get("target_code").getAsString();
            double tasa = jsonObject.get("conversion_rate").getAsDouble();

            if (!monedaBase.equalsIgnoreCase(convertidoDeMoneda) || !monedaDestino.equalsIgnoreCase(convertidoHaciaMoneda)) {
                throw new IllegalArgumentException("Moneda de destino no coincide con los datos de la API.");
            }

            return new TipoDeCambio(convertidoDeMoneda, convertidoHaciaMoneda, tasa,0,0);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la conversion: " + e.getMessage());
        }
        return null;
    }
}