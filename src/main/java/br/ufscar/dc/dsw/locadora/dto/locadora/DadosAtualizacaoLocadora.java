package br.ufscar.dc.dsw.locadora.dto.cliente;

import br.ufscar.dc.dsw.locadora.domain.Sexo;
import br.ufscar.dc.dsw.locadora.validation.BirthDate;
import br.ufscar.dc.dsw.locadora.validation.Name;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DadosAtualizacaoCliente(
    String username,

    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email,

    @Size(min = 14, max = 14)
    String cpf,

    @Size(min = 15, max = 15)
    String phoneNumber,

    @Enumerated(EnumType.STRING)
    Sexo sex,

    @BirthDate(message = "{BirthDate.cliente}")
    LocalDate birthDate) {
}
