package br.com.gilvanmuniz.util.request.convert;

import br.com.gilvanmuniz.exception.UnsupportedMathOperationException;

public class ConvertToDouble {
    public static  Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException(" Please set a numeric value! ");
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);
    }

}
