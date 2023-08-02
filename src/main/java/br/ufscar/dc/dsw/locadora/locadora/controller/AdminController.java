package br.ufscar.dc.dsw.locadora.locadora.controller;

import br.ufscar.dc.dsw.locadora.locadora.domain.Admin;
import br.ufscar.dc.dsw.locadora.locadora.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/admins")
public class AdminController {

  @Autowired
  private AdminRepository repository;


  @GetMapping
  public ResponseEntity<Page<Admin>> listar(@PageableDefault(size = 10) Pageable pageable) {
    Page<Admin> admins = repository.findAll(pageable);

    return ResponseEntity.ok(admins);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Admin> cadastrar(@RequestBody @Valid Admin admin, UriComponentsBuilder uriBuilder) {

    repository.save(admin);
    URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(admin.getId()).toUri();

    return ResponseEntity.created(uri).body(admin);
  }

  @PutMapping
  @Transactional
  public ResponseEntity<Admin> atualizar(@RequestBody @Valid Admin admin) {
    admin.atualizar(admin);

    return ResponseEntity.ok(admin);
  }


  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity deletar(@PathVariable Long id) {
    Admin admin = repository.getReferenceById(id);
    repository.delete(admin);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Admin> detalhar(@PathVariable Long id) {
    Admin admin = repository.getReferenceById(id);

    return ResponseEntity.ok(admin);
  }
}
