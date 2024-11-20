package br.com.fiap.exceptions;

public class AtividadeNaoEncontradaException extends RuntimeException {
    public AtividadeNaoEncontradaException(String message) {
        super(message);
    }
}
