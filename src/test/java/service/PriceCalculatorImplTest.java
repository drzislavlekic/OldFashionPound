package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PriceCalculatorImplTest {

  @Test
  void shouldCalculate() {
    final String firstValue = "5p 17s 8d";
    final String secondValue = "3p 4s 10d";

    final String price = PriceCalculator
        .get(firstValue)
        .add(secondValue)
        .parse();

    assertEquals("9p 2s 6d", price);
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
