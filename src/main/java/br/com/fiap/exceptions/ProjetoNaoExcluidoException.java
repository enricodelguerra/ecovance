package br.com.fiap.exceptions;

public class ProjetoNaoExcluidoException extends RuntimeException {
    public ProjetoNaoExcluidoException(String message) {
        super(message);
    }
}
