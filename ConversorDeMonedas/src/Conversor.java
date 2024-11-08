import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conversor {
    private JsonObject tasasCambio;

    public Conversor() {
        cargarTasasDeCambio();
    }

    private void cargarTasasDeCambio() {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/a124d000eba4b7de724d8e8b/latest/USD");
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonObject jsonObject = jp.parse(new InputStreamReader(request.getInputStream())).getAsJsonObject();

            if (jsonObject.has("conversion_tasas")) {
                tasasCambio = jsonObject.getAsJsonObject("conversion_tasas");
            } else {
                System.out.println("Error: No se encontraron las tasas de cambio en la respuesta de la API.");
                tasasCambio = null;
            }
        } catch (Exception e) {
            System.out.println("Error al cargar las tasas de cambio: " + e.getMessage());
            tasasCambio = null;
        }
    }

    public double convertir(double cantidad, String moneda, boolean aDolares) {
        if (tasasCambio == null) {
            System.out.println("Error: Tasas de cambio no disponibles. Verifica la conexión a la API.");
            return 0.0;
        }

        if (!tasasCambio.has(moneda)) {
            System.out.println("Error: La moneda " + moneda + " no está disponible en las tasas de cambio.");
            return 0.0;
        }

        double tasa = tasasCambio.get(moneda).getAsDouble();
        return aDolares ? cantidad / tasa : cantidad * tasa;
    }
}
