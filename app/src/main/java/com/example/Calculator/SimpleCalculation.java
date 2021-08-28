package com.example.Calculator;

import java.math.BigDecimal;

public class SimpleCalculation {

    static BigDecimal soThu1;
    static BigDecimal soThu2;

    public static double add(double st1, double st2) {
        soThu1 = new BigDecimal(Double.toString(st1));
        soThu2 = new BigDecimal(Double.toString(st2));

        double rs = soThu1.add(soThu2).doubleValue();
        return rs;
    }

    public static double sub(double st1, double st2) {
        soThu1 = new BigDecimal(Double.toString(st1));
        soThu2 = new BigDecimal(Double.toString(st2));

        double rs = soThu1.subtract(soThu2).doubleValue();
        return rs;
    }

    public static double mul(double st1, double st2) {
        soThu1 = new BigDecimal(Double.toString(st1));
        soThu2 = new BigDecimal(Double.toString(st2));

        double rs = soThu1.multiply(soThu2).doubleValue();
        return rs;
    }

    public static double div(double st1, double st2) {
        soThu1 = new BigDecimal(Double.toString(st1));
        soThu2 = new BigDecimal(Double.toString(st2));

        double rs = soThu1.divide(soThu2).doubleValue();
        return rs;
    }
}
