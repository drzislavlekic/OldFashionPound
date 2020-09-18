package data;

import java.util.regex.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDto {

  private static final Pattern pattern = Pattern.compile("^[0-9]*p[ ][0-9]*s[ ][0-9]*d$");

  private Integer pound;
  private Integer shilling;
  private Integer pence;


  public static PriceDto parseToPriceDto(final String value) {
    if (!isValidFormat(value)) {
      throw new IllegalArgumentException(String.format("Value %s is in wrong format", value));
    }

    final String[] values = value.split(" ");

    return PriceDto.builder()
        .pound(extractDigit(values[0]))
        .shilling(extractDigit(values[1]))
        .pence(extractDigit(values[2]))
        .build();
  }

  private static Boolean isValidFormat(final String value) {
    return pattern.matcher(value).matches();
  }

  private static Integer extractDigit(final String value) {
    return Integer.parseInt(value.substring(0, value.length() - 1));
  }


}
