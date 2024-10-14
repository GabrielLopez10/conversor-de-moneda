package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.modelos.ConvertidorMoneda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** Conversor de Monedas *****");
        System.out.println("Seleccione la moneda base (ej: USD, EUR, ARS): ");
        String monedaBase = scanner.nextLine().toUpperCase();

        System.out.println("Seleccione la moneda de destino (ej: USD, EUR, ARS): ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        try {
            double resultado = ConvertidorMoneda.convertirMoneda(monedaBase, monedaDestino, cantidad);
            System.out.println(cantidad + " " + monedaBase + " = " + resultado + " " + monedaDestino);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
