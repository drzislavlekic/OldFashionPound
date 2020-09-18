package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PriceCalculatorImplTest {

  @Test
  void shouldAdd() {
    final String firstValue = "5p 17s 8d";
    final String secondValue = "3p 4s 10d";

    final String price = PriceCalculator
        .get(firstValue)
        .add(secondValue)
        .parse();

    assertEquals("9p 2s 6d", price);
  }

  @Test
  void shouldSubtractWithPositiveValues() {
    final String firstValue = "5p 17s 8d";
    final String secondValue = "3p 4s 10d";

    final String price = PriceCalculator
        .get(firstValue)
        .subtract(secondValue)
        .parse();

    assertEquals("2p 12s 10d", price);
  }

  @Test
  void shouldSubtractWithNegativeValue() {
    final String firstValue = "5p 4s 8d";
    final String secondValue = "3p 17s 10d";

    final String price = PriceCalculator
        .get(firstValue)
        .subtract(secondValue)
        .parse();

    assertEquals("1p 6s 10d", price);
  }

  @Test
  void shouldReturnZeroForNegativePound() {
    final String firstValue = "2p 4s 8d";
    final String secondValue = "3p 17s 10d";

    final String price = PriceCalculator
        .get(firstValue)
        .subtract(secondValue)
        .parse();

    assertEquals("0p 0s 0d", price);
  }

  @Test
  void shouldMultiply() {
    final String firstValue = "5p 17s 8d";
    final Integer secondValue = 2;

    final String price = PriceCalculator
        .get(firstValue)
        .multiply(secondValue)
        .parse();

    assertEquals("11p 15s 4d", price);
  }

  @Test
  void shouldDivide() {
    final String firstValue = "18p 16s 1d";
    final Integer secondValue = 15;

    final String price = PriceCalculator
        .get(firstValue)
        .divide(secondValue)
        .parse();

    assertEquals("1p 1s 0d", price);
  }


  @Test
  void shouldThrowExceptionIfFormatIsWrong() {
    final String firstValue = "pp 72s 70d";
    final String secondValue = "2p 160s 80d";

    assertThrows(IllegalArgumentException.class, () -> PriceCalculator
        .get(firstValue)
        .add(secondValue)
        .parse());
  }


}
