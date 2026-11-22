package br.com.gilvanmuniz.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//slf4j é a biblioteca para trabalhar com logs
//  @RestController para fazer requisição
@RestController
public class TestLogController{
    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.trace("5 - This is an TRACE log - rastreamento");
        logger.debug("4 - This is an DEBUG log - programador");
        logger.info("3 - This is an INFO log - informação");
        logger.warn("2 - This is an WARN log - emprod");
        logger.error("1 - This is an ERRO log - emprod");
        return "Logs generated successfully!";
    }







}
