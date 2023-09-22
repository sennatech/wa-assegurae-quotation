package br.com.sennatech.wasddoquotation.domain;


import jakarta.validation.constraints.NotBlank;

public class InsuredAddress {
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String district;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    @NotBlank
    private String zipcode;
}
