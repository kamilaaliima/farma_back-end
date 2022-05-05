package com.farma.farma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farma.farma.model.Medicamentos;
import com.farma.farma.repository.MedicamentosRepository;

@RestController
@RequestMapping("/medicamentos")
@CrossOrigin("*")
public class MedicamentosController {
	
	@Autowired
	private MedicamentosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Medicamentos>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicamentos> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Medicamentos>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Medicamentos> post (@RequestBody Medicamentos medicamentos){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(medicamentos));
	}
	
	@PutMapping
	public ResponseEntity<Medicamentos> put (@RequestBody Medicamentos medicamentos){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(medicamentos));
	}
	
	@DeleteMapping
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
