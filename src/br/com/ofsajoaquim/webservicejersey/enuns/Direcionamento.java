package br.com.ofsajoaquim.webservicejersey.enuns;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Direcionamento {

    ALUGUEL("Aluguel"),
    VENDA("Venda");

    private String valor;

    Direcionamento(String valor) {
        this.valor = valor;
    }

    @JsonValue
    public String getValor() {
        return valor;
    }
}