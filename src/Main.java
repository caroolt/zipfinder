import br.com.zipfinder.models.AddressWriter;
import br.com.zipfinder.interfaces.Menu;
import br.com.zipfinder.models.Search;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       try {
           Menu menu = new Menu();
           AddressWriter writer = new AddressWriter();
           while (menu.isRunning()) {
               menu.displayMenu();
               menu.handleInput();
           }

           if (!menu.getUrl().isBlank()) {
               Search search = new Search(menu.getUrl());
               writer.writeAddressToFile(search.getSearchedAddress());
           }
       } catch (IOException | InterruptedException | JsonSyntaxException e) {
           throw new RuntimeException("Unable to obtain address from location or zip code");
       }
    }
}