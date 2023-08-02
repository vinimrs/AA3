package br.ufscar.dc.dsw.locadora.locadora.repository;

import br.ufscar.dc.dsw.locadora.locadora.domain.Admin;
import br.ufscar.dc.dsw.locadora.locadora.domain.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocadoraRepository extends JpaRepository<Locadora, Long> {
}
