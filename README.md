# ZipFinder

ZipFinder is a simple Java console application that allows users to search for Brazilian ZIP codes (CEP) or addresses using the ViaCEP API. The user can enter a ZIP code or an address (state, city, street), and the application will fetch the corresponding address or ZIP code and save the results to a file.

## Features

- Search for a Brazilian address by ZIP code.
- Search for a ZIP code by providing an address.
- Save the search results to a customizable file.

## Installation

### Prerequisites

- Java 22
- IntelliJ IDEA (or another Java IDE)
- [Gson library](https://github.com/google/gson) (Download the `gson-*.jar` file)

### Setting Up the Project

1. Download the `gson-*.jar` file from the [Gson GitHub releases page](https://github.com/google/gson/releases).
2. Open IntelliJ IDEA and create a new Java project.
3. Add the `gson-*.jar` file to your project's classpath:
   - Go to `File` > `Project Structure` > `Modules` > `Dependencies`.
   - Click `+` > `JARs or Directories` and select the `gson-*.jar` file.

### Running the Application

1. In IntelliJ, open `Main.java`.
2. Run the `main` method using the green play button or by right-clicking and selecting `Run 'Main.main()'`.

## Usage

Upon running the application, you'll be presented with a menu:

Want to find out a Brazilian ZIP code or address?
1- Zip code
2- Address
3- Leave

### ZIP Code Search

1. Select the option to search by ZIP code.
2. Enter the ZIP code you want to search for.
3. The application will fetch the corresponding address and prompt you to save the result to a file.

### Address Search

1. Select the option to search by address.
2. Enter the state (e.g., SP, MG).
3. Enter the city.
4. Enter the street or avenue name (without a complement) (e.g., Avenida Paulista).
5. The application will fetch the corresponding ZIP code(s) and prompt you to save the result to a file.

### Saving Results

After a search, you'll have the option to save the results to a file. By default, the file will be saved in the current directory as `ZipFinder-Address.txt`. You can also customize the file name and path.

## Project Structure

- `Main.java`: Entry point of the application.
- `Menu.java`: Handles the user interface and input.
- `Search.java`: Manages the API requests and responses.
- `AddressWriter.java`: Handles writing the search results to a file.
- `Address.java`: Represents an address object.

## Acknowledgments

- [ViaCEP](https://viacep.com.br/) for providing the free API service for ZIP code and address lookup.
- [Gson](https://github.com/google/gson) for the JSON parsing library used in this project.

