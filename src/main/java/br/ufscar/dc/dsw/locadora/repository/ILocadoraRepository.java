package br.ufscar.dc.dsw.locadora.repository;

import br.ufscar.dc.dsw.locadora.domain.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ILocadoraRepository extends JpaRepository<Locadora, Long> {
  Collection<Locadora> findAllByCnpj(String cnpj);

  Locadora findByCnpj(String cnpj);
}
