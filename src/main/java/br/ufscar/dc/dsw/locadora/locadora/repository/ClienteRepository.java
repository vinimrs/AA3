package br.ufscar.dc.dsw.locadora.locadora.repository;

import br.ufscar.dc.dsw.locadora.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.locadora.domain.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
