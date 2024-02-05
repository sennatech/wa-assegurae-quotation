package br.com.sennatech.wasddoquotation.domain.dto;

import br.com.sennatech.wasddoquotation.domain.Coverage;
import br.com.sennatech.wasddoquotation.domain.InsuredAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class QuotationRequestDTO {
    @Valid
    @NotNull
    List<Coverage> coverages;

    @Valid
    @NotNull
    InsuredAddress insuredAddress;

    String documentNumber;
}

