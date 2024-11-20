package br.com.fiap.exceptions;

public class ErroValidacaoException extends RuntimeException {
    public ErroValidacaoException(String message) {
        super(message);
    }
}
