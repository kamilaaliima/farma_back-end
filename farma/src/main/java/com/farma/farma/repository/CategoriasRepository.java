package com.farma.farma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.farma.farma.model.Categorias;


@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>{
	public List<Categorias> findAllByCategoriaProdutoContainingIgnoreCase (@Param("categoriaProduto") String categoriaProduto);
	

}