package br.com.sennatech.wasddoquotation.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record Coverage(@NotNull Integer code, @NotBlank String name,@NotNull BigDecimal value) {
}
