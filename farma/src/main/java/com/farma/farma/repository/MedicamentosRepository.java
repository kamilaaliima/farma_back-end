package com.farma.farma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.farma.farma.model.Medicamentos;


@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long>{
	public List<Medicamentos> findAllByNomeContainingIgnoreCase (@Param("nome") String nome);
	

}