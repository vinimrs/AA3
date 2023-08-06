package br.ufscar.dc.dsw.locadora.repository;

import br.ufscar.dc.dsw.locadora.domain.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocadoraRepository extends JpaRepository<Locadora, Long> {
}
