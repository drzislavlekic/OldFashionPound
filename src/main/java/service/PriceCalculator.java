package service;

public interface PriceCalculator {

  static PriceCalculator get(String value) {
    return new PriceCalculatorImpl(value);
  }

  PriceCalculator add(String value);

  String parse();

}
