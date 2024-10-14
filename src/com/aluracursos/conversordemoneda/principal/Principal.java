package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.calculos.ConvertirCalculo;
import com.aluracursos.conversordemoneda.modelos.ConvertidorMoneda;

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
                    System.out.println("Introduce la nueva moneda (por ejemplo, ARS, USD): ");
                    monedaBase = entrada.next().toUpperCase();
                    System.out.println("Moneda actualizada a: " + monedaBase);
                    break;
                case 2:
                    System.out.println("Introduce la moneda a la que quieres convertir (por ejemplo, EUR, JPY): ");
                    String monedaDestino = entrada.next().toUpperCase();

                    System.out.println("Introduce la cantidad que quieres convertir: ");
                    double cantidad = entrada.nextDouble();

                    try {
                        double resultado = ConvertirCalculo.convertirMoneda(monedaBase, monedaDestino, cantidad);
                        System.out.println(cantidad + " " + monedaBase + " equivale a " + resultado + " " + monedaDestino);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error en la conversion: " + e.getMessage());
                    }
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
}
