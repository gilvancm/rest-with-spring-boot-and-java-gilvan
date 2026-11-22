package br.com.gilvanmuniz.controllers;


import br.com.gilvanmuniz.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "name, %s";
    private final AtomicLong count = new AtomicLong();

    // URL padrão de busca
// http://localhost:8080/greeting?name=leandro

    /* declara a chamada
       comenta bloco e
       // comanta linha

     */
    @RequestMapping("/greeting")
    // este metodo ele faz o auto incremento mocado e o resto
   public Greeting greeting(
       @RequestParam(value = "name", defaultValue = "Wold")
       // o @Resquestparam  seta o valor name
       String name){

       return new Greeting(count.incrementAndGet(), String.format(template, name));

    }


}
