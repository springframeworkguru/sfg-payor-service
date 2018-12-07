package guru.sfgpay.payor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jt on 2018-12-07.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    @Size(min=2, max=255, message = "Line 1 of the address must be between {min} and {max} characters long")
    @NotNull(message = "Line 1 of the address is mandatory")
    private String line1;

    @Size(max = 255, message = "Line 2 of the address can be no more than {max} characters long")
    private String line2;

    @Size(max = 255, message = "Line 3 of the address can be no more than {max} characters long")
    private String line3;

    @Size(max = 255, message = "Line 4 of the address can be no more than {max} characters long")
    private String line4;

    @Size(min=2, max=100, message = "City must be between {min} and {max} characters long")
    @NotNull(message = "City is mandatory")
    private String city;

    @Size(min=2, max=100, message = "County or Province must be between {min} and {max} characters long")
    private String countyOrProvince;

    @Size(min=2, max=30, message = "Zip or Postcode must be between {min} and {max} characters long")
    private String zipOrPostcode;

    @Size(min=2, max=50, message = "Country must be between {min} and {max} characters long")
    @NotNull(message = "Country is mandatory")
    private String country;
}
