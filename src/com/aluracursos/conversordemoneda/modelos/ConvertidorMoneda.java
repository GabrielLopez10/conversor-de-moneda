package com.aluracursos.conversordemoneda.modelos;

import java.io.IOException;

public class ConvertidorMoneda {
    public static TipoDeCambio obtenerTasaDeCambio(String base, String destino) throws IOException, InterruptedException {
        // llama al servicio API
        String jsonResponse = ServicioApi.obtenerDatosCambio(base);

        // busca la tasa de cambio del destino en el JSON
        int index = jsonResponse.indexOf("\"" + destino + "\":");
        if (index == -1) {
            throw new IllegalArgumentException("Moneda de destino no encontrada");
        }
        String tasaString = jsonResponse.substring(index + destino.length() + 3, jsonResponse.indexOf(",", index));

        double tasa = Double.valueOf(tasaString);
        return new TipoDeCambio(base, destino, tasa);
    }

    // metodo para convertir la cantidad de una moneda a otra
    public static double convertirMoneda(String base, String destino, double cantidad) throws IOException, InterruptedException {
        TipoDeCambio tipoDeCambio = obtenerTasaDeCambio(base, destino);
        return cantidad * tipoDeCambio.tasa();
    }
}
