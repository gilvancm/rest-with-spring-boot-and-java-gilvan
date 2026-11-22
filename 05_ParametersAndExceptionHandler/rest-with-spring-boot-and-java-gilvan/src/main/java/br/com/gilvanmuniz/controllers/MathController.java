package br.com.gilvanmuniz.controllers;

import br.com.gilvanmuniz.exception.UnsupportedMathOperationException;
import br.com.gilvanmuniz.math.SimplesMath;
import br.com.gilvanmuniz.util.request.validar.ValidarNumero;
import br.com.gilvanmuniz.util.request.convert.ConvertToDouble;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimplesMath simplesMath = new SimplesMath();
    private ValidarNumero validarNumero = new ValidarNumero();
    private ConvertToDouble convertToDouble = new ConvertToDouble();

   @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ) throws Exception {
        if (!ValidarNumero.isNumeric(numberOne) || !ValidarNumero.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(" Please set a numeric value! ");
      //  return ConvertToDouble.convertToDouble(numberOne) + ConvertToDouble.convertToDouble(numberTwo);
       return simplesMath.sum(ConvertToDouble.convertToDouble(numberOne), ConvertToDouble.convertToDouble(numberTwo));
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ) throws Exception {
        if (!ValidarNumero.isNumeric(numberOne) || !ValidarNumero.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(" Please set a numeric value! ");
        return simplesMath.sub(ConvertToDouble.convertToDouble(numberOne), ConvertToDouble.convertToDouble(numberTwo));
    }

    @RequestMapping("/mul/{numberOne}/{numberTwo}")
    public Double mul(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTow
    ) throws Exception {
        if(!ValidarNumero.isNumeric(numberOne) || !ValidarNumero.isNumeric(numberTow))
            throw new UnsupportedMathOperationException(" Please set a numeric value! ");
      //  return simplesMath.mul (ConvertToDouble.convertToDouble(numberOne), ConvertToDouble.convertToDouble(numberTwo));
        return simplesMath.mul(ConvertToDouble.convertToDouble(numberOne), ConvertToDouble.convertToDouble(numberTow));
    }


    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if (!ValidarNumero.isNumeric(numberOne) || !ValidarNumero.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(" Please set a numeric value! ");
        return simplesMath.div(ConvertToDouble.convertToDouble(numberOne), ConvertToDouble.convertToDouble(numberTwo));
    }


    @RequestMapping("/med/{numberOne}/{numberTwo}")
    public Double med(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ) throws Exception{
        if (!ValidarNumero.isNumeric(numberOne) || !ValidarNumero.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(" Please set a numeric value! ");

        return simplesMath.med(ConvertToDouble.convertToDouble(numberOne), ConvertToDouble.convertToDouble(numberTwo));
    }


    @RequestMapping("/rzq/{numberOne}")
    public Double rzq(
            @PathVariable("numberOne") String numberOne
    ) throws Exception{
        if (!ValidarNumero.isNumeric(numberOne))
            throw new UnsupportedMathOperationException(" Please set a numeric value! ");
       // Double result =    Math.sqrt(ConvertToDouble.convertToDouble(numberOne));
       // return result;
        return simplesMath.rzq(ConvertToDouble.convertToDouble(numberOne));
    }
}



