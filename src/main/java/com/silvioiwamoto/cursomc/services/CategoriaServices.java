package com.silvioiwamoto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silvioiwamoto.cursomc.domain.Categoria;
import com.silvioiwamoto.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaServices {

		@Autowired
		private CategoriaRepository repo;
		
		public Categoria buscar(Integer id) {
			Optional<Categoria> obj = repo.findById(id);
			return obj.orElse(null);
		}		
}
