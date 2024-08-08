package br.com.zipfinder.models;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AddressWriter {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    private final Scanner scanner = new Scanner(System.in);


    public void writeAddressToFile(String searchedAddress) throws IOException {
        JsonElement addressJson = JsonParser.parseString(searchedAddress);
        String pathAndFileName = "ZipFinder-Address.txt";
        System.out.println("Do you want to customize the path or name of the file that will be generated? (y/n)");
        String willCustomize = scanner.nextLine();
        if(willCustomize.equalsIgnoreCase("y")) {
            System.out.println("What is the path and name of the file you want to save? (ex.: C:/Documents/ZipFinder-Address.txt)");
            pathAndFileName = scanner.nextLine();
        } else {
            System.out.println("The file will be saved in this directory with the name " + pathAndFileName);
        }

        if (addressJson.isJsonArray()) {
            Address[] addresses = gson.fromJson(searchedAddress, Address[].class);
            this.writeFile(pathAndFileName, addresses);

        } else if (addressJson.isJsonObject()) {
            Address address = gson.fromJson(searchedAddress, Address.class);
            this.writeFile(pathAndFileName, address);
        }
    }


    private void writeFile(String fileName, Address[] addresses) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        writer.write(Arrays.toString(addresses));
        writer.close();
    }

    private void writeFile(String fileName, Address address) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        writer.write(address.toString());
        writer.close();
    }

}
