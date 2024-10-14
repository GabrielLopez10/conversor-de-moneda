package com.aluracursos.conversordemoneda.calculos;

import com.aluracursos.conversordemoneda.modelos.ConvertidorMoneda;
import com.aluracursos.conversordemoneda.modelos.TipoDeCambio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ConvertirCalculo {
    private static final DecimalFormat formato = new DecimalFormat("###0.00");

    // metodo para convertir la cantidad de una moneda a otra
    public static TipoDeCambio convertirMoneda(String monedaBase, String monedaDestino, double cantidad){
        TipoDeCambio tipoDeCambio = ConvertidorMoneda.obtenerTasaDeCambio(monedaBase, monedaDestino);
        if (tipoDeCambio == null) {
            throw new IllegalArgumentException("No se pudo obtener la tasa de cambio.");
        }

        double resultadoSinRedondeo = cantidad * tipoDeCambio.tasa();
        BigDecimal resultadoRedondeado = new BigDecimal(resultadoSinRedondeo).setScale(2, RoundingMode.HALF_UP);
        double resultado = resultadoRedondeado.doubleValue();

        tipoDeCambio = new TipoDeCambio(tipoDeCambio.monedaBase(), tipoDeCambio.monedaDestino(), tipoDeCambio.tasa(), cantidad, resultado);
        return tipoDeCambio;
    }

    public static String formatearResultado(double cantidad) {
        return formato.format(cantidad);
    }
}
