package br.com.fiap.exceptions;

public class ProjetoNaoEncontradoException extends RuntimeException {
    public ProjetoNaoEncontradoException(String message) {
        super(message);
    }
}
