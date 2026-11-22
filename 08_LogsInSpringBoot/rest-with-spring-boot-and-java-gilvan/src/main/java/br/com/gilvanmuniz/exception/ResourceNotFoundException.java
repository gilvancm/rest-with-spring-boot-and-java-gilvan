package br.com.gilvanmuniz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// com o annotattion -->  @ResponseStatus
// devemos atribuir o para manipular HttpStatus.BAD_REQUEST

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message)
    {super(message); }
}
