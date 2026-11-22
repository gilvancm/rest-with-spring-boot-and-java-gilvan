package br.com.gilvanmuniz.math;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//classe especifica para fazer as operações tirando a responsabilidade do controle
// classe Math é fazer as contas e resoulver e retoar nara para classe  para MathController
// esta classe é varios metodos para enchugar a parte de controles
@RestController
@RequestMapping
public class SimplesMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double mul(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double div(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double med(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo)/2;
    }

    public Double rzq(Double numberOne) {
        return Math.sqrt(numberOne) ;
    }

}