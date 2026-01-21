package br.com.lhdelivery.utils;

public class MoneyFormatter {
    public static String formatter(double value) {
        return String.format("%.2f", value);
    }
}
