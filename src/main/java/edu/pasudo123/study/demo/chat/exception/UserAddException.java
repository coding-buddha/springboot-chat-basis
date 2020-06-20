package edu.pasudo123.study.demo.chat.exception;

public class UserAddException extends RuntimeException{
    public UserAddException(final String format, final Object... args) {
        super(String.format(format, args));
    }
}
