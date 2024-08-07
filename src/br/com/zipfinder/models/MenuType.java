package br.com.zipfinder.models;

public enum MenuType {
    MAIN_MENU,
    ZIP_CODE_MENU,
    ADDRESS_MENU;

    public String getAux() {
        return switch (this) {
            case ZIP_CODE_MENU -> """
          ***************
          Zip Code Menu:
          1- Enter ZIP code to search
          2- Back to Main Menu
          ***************
         """;
            case ADDRESS_MENU -> """
          ***************
          Address Menu:
          1- Enter address to search
          2- Back to Main Menu
          ***************
         """;
            default -> """
          ***************
          Want to find out a brazilian ZIP code or address?
          1- Zip code
          2- Address
          3- Leave
          ***************
         """;
        };
    }
    }
