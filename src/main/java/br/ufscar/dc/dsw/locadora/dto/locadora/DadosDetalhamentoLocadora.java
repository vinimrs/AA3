package br.ufscar.dc.dsw.locadora.dto.cliente;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.domain.Sexo;

import java.time.LocalDate;
import java.util.List;

public record DadosDetalhamentoCliente(
    Long id, String username, String name, String email,
    String cpf, String phoneNumber, Sexo sex, LocalDate birthDate, List<Locacao> locacoes) {
  public DadosDetalhamentoCliente(Cliente cliente) {
    this(cliente.getId(), cliente.getUsername(), cliente.getName(), cliente.getEmail(),
        cliente.getCpf(), cliente.getPhoneNumber(), cliente.getSex(), cliente.getBirthDate(),
        cliente.getLocacoes());
  }

}
