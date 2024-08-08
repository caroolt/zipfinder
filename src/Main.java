import br.com.zipfinder.models.Address;
import br.com.zipfinder.models.Menu;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (menu.isRunning()) {
            menu.displayMenu();
            menu.handleInput();
        }

        if (!menu.getUrl().isBlank()) {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(menu.getUrl()))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement addressJson = JsonParser.parseString(response.body());

            if (addressJson.isJsonArray()) {
                Address[] addresses = gson.fromJson(response.body(), Address[].class);
                FileWriter writer = new FileWriter("Addresses.txt");

                writer.write(Arrays.toString(addresses));
                writer.close();

            } else if (addressJson.isJsonObject()) {
                Address address = gson.fromJson(response.body(), Address.class);
                FileWriter writer = new FileWriter(address.logradouro() + ".txt");

                writer.write(address.toString());
                writer.close();
            }
        }
    }
}