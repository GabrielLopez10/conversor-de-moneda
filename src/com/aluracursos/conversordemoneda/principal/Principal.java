package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.calculos.ConvertirCalculo;
import com.aluracursos.conversordemoneda.modelos.GeneradorDeArchivo;
import com.aluracursos.conversordemoneda.modelos.TipoDeCambio;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        String monedaBase = "ARS";

        while (continuar){
            System.out.println("\n*** Conversor de Monedas ***");
            System.out.println("1. Cambiar moneda base (actual: " + monedaBase + ")");
            System.out.println("2. Convertir a otra moneda");
            System.out.println("3. Salir");
            System.out.println("Elige una opción: ");

            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    monedaBase = cambiarMonedaBase(entrada);
                    break;
                case 2:
                    realizarConversion(entrada, monedaBase);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no valida. Por favor, elige una opcion entre 1 y 3.");
                    break;
            }
        }
        entrada.close();
    }

    private static String cambiarMonedaBase(Scanner entrada) {
        System.out.println("Introduce la nueva moneda (por ejemplo, ARS, USD): ");
        String nuevaMonedaBase = entrada.next().toUpperCase();
        System.out.println("Moneda actualizada a: " + nuevaMonedaBase);
        return nuevaMonedaBase;
    }

    private static void realizarConversion(Scanner entrada, String monedaBase) {
        System.out.println("Introduce la moneda a la que quieres convertir (por ejemplo, EUR, JPY): ");
        String monedaDestino = entrada.next().toUpperCase();

        System.out.println("Introduce la cantidad que quieres convertir: ");
        double cantidad = entrada.nextDouble();

        try {
            TipoDeCambio tipoDeCambio = ConvertirCalculo.convertirMoneda(monedaBase, monedaDestino, cantidad);

            mostrarResultado(cantidad, monedaBase, tipoDeCambio.resultado(), monedaDestino);

            guardarConversionEnJson(tipoDeCambio);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en la conversion: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    private static void mostrarResultado(double cantidad, String monedaBase, double resultado, String monedaDestino) {
        System.out.println("*** Conversión ***");
        System.out.println(ConvertirCalculo.formatearResultado(cantidad) + " " + monedaBase + " equivale a " + ConvertirCalculo.formatearResultado(resultado) + " " + monedaDestino);
    }

    private static void guardarConversionEnJson(TipoDeCambio tipoDeCambio) throws IOException {
        GeneradorDeArchivo generador = new GeneradorDeArchivo();
        generador.guardarJson(tipoDeCambio);
        System.out.println("Datos de la tasa de cambio guardados en archivo JSON.");
    }
}
