package service;

import data.PriceDto;

public final class PriceCalculatorImpl implements PriceCalculator {

  private final PriceDto priceDto;

  protected PriceCalculatorImpl(final String value) {
    this.priceDto = PriceDto.parseToPriceDto(value);
  }

  @Override
  public PriceCalculator add(final String value) {
    final PriceDto otherValue = PriceDto.parseToPriceDto(value);

    priceDto.setPound(priceDto.getPound() + otherValue.getPound());
    priceDto.setShilling(priceDto.getShilling() + otherValue.getShilling());
    priceDto.setPence(priceDto.getPence() + otherValue.getPence());

    setPences();
    setShillingAndPound();

    return this;
  }

  @Override
  public PriceCalculator subtract(String value) {
    final PriceDto otherValue = PriceDto.parseToPriceDto(value);

    priceDto.setPound(priceDto.getPound() - otherValue.getPound());
    priceDto.setShilling(priceDto.getShilling() - otherValue.getShilling());
    priceDto.setPence(priceDto.getPence() - otherValue.getPence());

    setPences();
    setShillingAndPound();
    return this;
  }

  @Override
  public PriceCalculator multiply(Integer value) {
    priceDto.setPound(priceDto.getPound() * value);
    priceDto.setShilling(priceDto.getShilling() * value);
    priceDto.setPence(priceDto.getPence() * value);

    setPences();
    setShillingAndPound();
    return this;
  }

  @Override
  public PriceCalculator divide(Integer value) {
    priceDto.setPound(priceDto.getPound() / value);
    priceDto.setShilling(priceDto.getShilling() / value);
    priceDto.setPence(priceDto.getPence() / value);

    setPences();
    setShillingAndPound();
    return this;
  }

  @Override
  public String parse() {
    return priceDto.getPound().toString() + "p" + " "
        + priceDto.getShilling().toString() + "s" + " " + priceDto.getPence().toString() + "d";
  }

  private void setPences() {
    priceDto.setShilling((priceDto.getPence() / 12) + priceDto.getShilling());
    priceDto.setPence(priceDto.getPence() % 12);

    while (priceDto.getPence() < 0) {
      priceDto.setShilling(priceDto.getShilling() - 1);
      priceDto.setPence(priceDto.getPence() + 12);
    }
  }

  private void setShillingAndPound() {
    priceDto.setPound((priceDto.getShilling() / 20) + priceDto.getPound());
    priceDto.setShilling(priceDto.getShilling() % 20);

    while (priceDto.getShilling() < 0) {
      priceDto.setPound(priceDto.getPound() - 1);
      priceDto.setShilling(priceDto.getShilling() + 20);
    }

    if (priceDto.getPound() < 0) {
      setToZero();
    }
  }

  private void setToZero() {
    priceDto.setPound(0);
    priceDto.setShilling(0);
    priceDto.setPence(0);
  }

}
