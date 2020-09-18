package service;

/**
 The {@code PriceCalculator} class represents the arithmetic operations for
 * old UK prices given explicit format ("p s d"). If format isn't correct then the
 * (@code IllegalArgumentException) message will be thrown
 * Its a static initializer with a builder pattern so
 * chaining methods are provided.

 * @author Drzislav Lekic
 */
public interface PriceCalculator {

  /**
   * Creates new PriceCalculatorImpl instance and performs validation for given value
   * for its format where you define your first value
   */
  static PriceCalculator get(String value) {
    return new PriceCalculatorImpl(value);
  }

  /**
   * Performs validation for given value for its format and adds it
   */
  PriceCalculator add(String value);

  /**
   * Performs validation for given value for its format and subtracts it
   */
  PriceCalculator subtract(String value);

  /**
   * Multiplies by given value
   */
  PriceCalculator multiply(Integer value);


  /**
   * Divides by given value
   */
  PriceCalculator divide(Integer value);

  /**
   * Creates {@code String} correct format("p s d") at the end of all operations and it returns result
   */
  String parse();

}
