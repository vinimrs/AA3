package br.ufscar.dc.dsw.locadora.dto.locadora;

import br.ufscar.dc.dsw.locadora.validation.formats.Name;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoLocadora(
    String username,

    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email,

    @Size(min = 18, max = 18, message = "{Size.locadora.CNPJ}")
    String cnpj,

    String city) {
}
