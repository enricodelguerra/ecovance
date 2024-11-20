package br.com.fiap.exceptions;

public class AtividadeNaoExcluidaException extends RuntimeException {
    public AtividadeNaoExcluidaException(String message) {
        super(message);
    }
}
