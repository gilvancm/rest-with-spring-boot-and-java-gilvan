package br.com.gilvanmuniz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// com o annotattion -->  @ResponseStatus
// devemos atribuir o para manipular HttpStatus.BAD_REQUEST

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{
    public UnsupportedMathOperationException(String message)
    {super(message); }
}
