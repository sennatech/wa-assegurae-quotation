package br.com.sennatech.wasddoquotation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class DataQuotation {
    private List<String> coverageTypes;
    private String quotationNumber;
    private BigDecimal amount;
    private InsuredAddress address;
    private String documentNumber;

}
