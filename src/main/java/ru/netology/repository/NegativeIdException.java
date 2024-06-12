package ru.netology.repository;

public class NegativeIdException extends RuntimeException {
    public NegativeIdException(String message) {
        super(message);
    }

}
