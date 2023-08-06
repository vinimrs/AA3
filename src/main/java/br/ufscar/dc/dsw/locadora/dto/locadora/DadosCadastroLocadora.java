package br.ufscar.dc.dsw.locadora.dto.locadora;

import br.ufscar.dc.dsw.locadora.validation.Name;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueCNPJ;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueEmail;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroLocadora(
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

    @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
    @NotBlank
    @Size(min = 18, max = 18, message = "{Size.locadora.CNPJ}")
    String cnpj,

    @NotBlank
    String city) {
}
