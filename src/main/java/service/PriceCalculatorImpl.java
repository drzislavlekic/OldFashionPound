package service;

import data.PriceDto;

public final class PriceCalculatorImpl implements PriceCalculator {

  private final PriceDto priceDto;

  protected PriceCalculatorImpl(final String value) {
    this.priceDto = PriceDto.parseToPriceDto(value);
  }

  @Override
  public String parse() {
    return priceDto.getPound().toString() + "p" + " "
        + priceDto.getShilling().toString() + "s" + " " + priceDto.getPence().toString() + "d";
  }

  public PriceCalculator add(final String value) {

    final PriceDto otherValue = PriceDto.parseToPriceDto(value);

    priceDto.setPound(priceDto.getPound() + otherValue.getPound());
    priceDto.setShilling(priceDto.getShilling() + otherValue.getShilling());
    priceDto.setPence(priceDto.getPence() + otherValue.getPence());

    setPences();
    setShillingAndPound();

    return this;
  }

  private void setPences() {
    priceDto.setShilling((priceDto.getPence() / 12) + priceDto.getShilling());
    priceDto.setPence(priceDto.getPence() % 12);
  }

  private void setShillingAndPound() {
    priceDto.setPound((priceDto.getShilling() / 20) + priceDto.getPound());
    priceDto.setShilling(priceDto.getShilling() % 20);
  }

}
