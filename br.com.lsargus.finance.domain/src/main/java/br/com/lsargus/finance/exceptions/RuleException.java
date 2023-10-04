package br.com.lsargus.finance.exceptions;

public class RuleException extends Exception {

    public RuleException() { super(); }

    public RuleException(String message) {
        super(message);
    }

    public RuleException(String message, Throwable cause) {
        super(message, cause);
    }
}
