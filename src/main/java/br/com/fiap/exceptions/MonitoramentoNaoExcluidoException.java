package br.com.fiap.exceptions;

public class MonitoramentoNaoExcluidoException extends RuntimeException {
    public MonitoramentoNaoExcluidoException(String message) {
        super(message);
    }
}
