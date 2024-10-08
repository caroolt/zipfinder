package br.com.zipfinder.interfaces;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Menu {
    private MenuEnum currentMenu = MenuEnum.MAIN_MENU;
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private String url = "";

    public String getUrl() {
        return url;
    }

    public boolean isRunning() {
        return running;
    }

    public void displayMenu() {
        System.out.println(currentMenu.getAux());
    }

    public void handleInput() {
        int selectedOption = scanner.nextInt();
        scanner.nextLine();

        switch (currentMenu) {
            case MAIN_MENU -> handleMainMenu(selectedOption);
            case ZIP_CODE_MENU -> handleZipCodeMenu(selectedOption);
            case ADDRESS_MENU -> handleAddressMenu(selectedOption);
        }
    }

    private void handleMainMenu(int option) {
        switch (option) {
            case 1 -> currentMenu = MenuEnum.ZIP_CODE_MENU;
            case 2 -> currentMenu = MenuEnum.ADDRESS_MENU;
            case 3 -> running = false;
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void handleZipCodeMenu(int option) {
        switch (option) {
            case 1 -> {
                System.out.println("Enter ZIP code to search: ");
                String zipCode = scanner.nextLine();
                url = String.format("https://viacep.com.br/ws/%s/json/", zipCode);
                running = false;
            }
            case 2 -> currentMenu = MenuEnum.MAIN_MENU;
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void handleAddressMenu(int option) {
        switch (option) {
            case 1 -> {
                System.out.println("Enter State: (ex.: SP, MG)");
                String uf = scanner.nextLine();
                System.out.println("Enter City: ");
                String city = scanner.nextLine();
                // manual coding of spaces because the via cep API only accepts if there is a space and if you put the + that is put in URLEncoder it doesn't work.
                city = city.replace(" ", "%20");
                System.out.println("Enter street or avenue without a complement: ");
                String address = scanner.nextLine();
                address = URLEncoder.encode(address, StandardCharsets.UTF_8);
                url = String.format("https://viacep.com.br/ws/%s/%s/%s/json/", uf, city, address);
                running = false;
            }
            case 2 -> currentMenu = MenuEnum.MAIN_MENU;
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

}
