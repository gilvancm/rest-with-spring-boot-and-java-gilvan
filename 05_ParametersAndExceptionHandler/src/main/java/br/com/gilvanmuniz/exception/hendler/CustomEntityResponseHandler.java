package br.com.gilvanmuniz.exception.hendler;

import br.com.gilvanmuniz.exception.ExceptionResponse;
import br.com.gilvanmuniz.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// Hendler = manipulador
// Advice = conselho , serve para concentra alguns tratamentos espalhado em todos os controles
// ai vai formatar nossa excessão mais elegante

@ControllerAdvice
@RestController
// vamos agora implementar nosso codigo
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    // vamos acresentar noos primeiro metodo um exceção generica
   // qual a exceção que ele vai tratar
     @ExceptionHandler(Exception.class)
     // WebRequest --> chamado  request
    public final ResponseEntity<ExceptionResponse> handleALLException(Exception ex, WebRequest request){

        ExceptionResponse response = new ExceptionResponse(
            //passamos e definimos os parametros
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // usa control d para duplicar o metodo
  @ExceptionHandler(UnsupportedMathOperationException.class)
     // WebRequest --> chamado  request
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception ex, WebRequest request){

        ExceptionResponse response = new ExceptionResponse(
            //passamos e definimos os parametros
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}
