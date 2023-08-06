package br.ufscar.dc.dsw.locadora.dto.locacao;

import br.ufscar.dc.dsw.locadora.validation.classlevel.ValidCadastroLocacao;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@ValidCadastroLocacao(message = "{ValidLocacao.locacao}")
public record DadosCadastroLocacao(
    @NotNull
    LocalTime hour,

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    LocalDate date,

    @NotNull
    Long rentalCompanyId,

    @NotNull
    Long clientId) {
}
