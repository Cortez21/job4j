package ru.job4j.converter;

/**
 * Класс для вычисления конвертации валют (доллар - евро - рубль).
 */
public class Converter {

    /**
     * Подсчет рубля к евро.
     * @param value - входные значения рубля
     * @return результат в евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Подсчет рубля к долларам.
     * @param value - входные значения рубля.
     * @return - возвращаемые значения в долларах.
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Подсчет евро к рублю.
            * @param value - входное значение кол-ва евро.
            * @return - возвращает кол-во рублей.
            */
    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Подсчет доллара к рублю.
     * @param value - входное значение кол-ва долларов.
     * @return - возвращает кол-во рублей.
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
}
