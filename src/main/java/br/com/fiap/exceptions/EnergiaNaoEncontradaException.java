package br.com.fiap.exceptions;

public class EnergiaNaoEncontradaException extends RuntimeException {
    public EnergiaNaoEncontradaException(String message) {
        super(message);
    }
}
