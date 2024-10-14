package com.aluracursos.conversordemoneda.calculos;

import com.aluracursos.conversordemoneda.modelos.ConvertidorMoneda;
import com.aluracursos.conversordemoneda.modelos.TipoDeCambio;

public class ConvertirCalculo {
    // metodo para convertir la cantidad de una moneda a otra
    public static double convertirMoneda(String monedaBase, String monedaDestino, double cantidad){
        TipoDeCambio tipoDeCambio = ConvertidorMoneda.obtenerTasaDeCambio(monedaBase, monedaDestino);
        if (tipoDeCambio == null) {
            throw new IllegalArgumentException("No se pudo obtener la tasa de cambio.");
        }
        return cantidad * tipoDeCambio.tasa();
    }
}
