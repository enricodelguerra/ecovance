package br.com.fiap.exceptions;

public class MonitoramentoNaoEncontradoException extends RuntimeException {
    public MonitoramentoNaoEncontradoException(String message) {
        super(message);
    }
}
