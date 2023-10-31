package br.com.sennatech.wasddoquotation.domain;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InsuredAddress {
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String neighbourhood;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    @NotBlank
    private String zipcode;
}
