package br.ufscar.dc.dsw.locadora.dto.cliente;

import br.ufscar.dc.dsw.locadora.validation.formats.BirthDate;
import br.ufscar.dc.dsw.locadora.validation.formats.BirthDateField;
import br.ufscar.dc.dsw.locadora.validation.formats.Name;
import br.ufscar.dc.dsw.locadora.validation.formats.Sex;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueCPF;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueEmail;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DadosCadastroCliente(
    @UniqueUsername(message = "{Unique.user.username}")
    @NotBlank
    String username,

    @NotBlank
    String password,

    @NotBlank
    @Name(message = "{Name.user.name}")
    String name,

    @UniqueEmail(message = "{Unique.user.email}")
    @NotBlank
    @Email
    String email,

    @UniqueCPF(message = "{Unique.cliente.CPF}")
    @NotBlank
    @Size(min = 15, max = 15, message = "{Size.cliente.CPF}")
    String cpf,

    @NotBlank
    @Size(min = 14, max = 14, message = "{Size.cliente.phone}")
    String phoneNumber,

    @Sex(message = "{Sex.cliente}")
    @NotBlank
    String sex,

    @BirthDateField(message = "{BirthDate.cliente}")
    @NotNull
    String birthDate) {
}
