import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaTasaCambio {

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/2d7ddb8e1754772c3f26676d/latest/";

    public static double obtenerTasa(String monedaBase, String monedaDestino) {
        try {
            String url = BASE_URL + monedaBase;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            return rates.get(monedaDestino).getAsDouble();
        } catch (Exception e) {
            System.out.println("Error al consultar la API: " + e.getMessage());
            return -1;
        }
    }
}