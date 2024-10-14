package com.aluracursos.conversordemoneda.modelos;

public record TipoDeCambio(String monedaBase,
                           String monedaDestino,
                           double tasa,
                           double cantidad,
                           double resultado) {
}
