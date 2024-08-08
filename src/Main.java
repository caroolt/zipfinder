import br.com.zipfinder.models.AddressWriter;
import br.com.zipfinder.interfaces.Menu;
import br.com.zipfinder.models.Search;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
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
    }
}