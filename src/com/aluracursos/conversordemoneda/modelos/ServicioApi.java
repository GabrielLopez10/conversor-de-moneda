package com.aluracursos.conversordemoneda.modelos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ServicioApi {
    private static final String API_KEY = cargarApiKey();

    private static String cargarApiKey() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/com/aluracursos/conversordemoneda/recursos/config.properties")){
            properties.load(input);
            return properties.getProperty("api.key");
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la API key", e);
        }
    }

    public static String obtenerDatosCambio(String base, String destino) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + destino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
