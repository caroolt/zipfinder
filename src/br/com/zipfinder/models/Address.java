package br.com.zipfinder.models;

public record Address(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {

    @Override
    public String toString() {
        return "Address: " + logradouro + " " + complemento + ", "+ bairro + ", " + localidade + ", " + uf + " - " + cep;
    }
}
