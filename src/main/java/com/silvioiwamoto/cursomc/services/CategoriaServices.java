package com.silvioiwamoto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silvioiwamoto.cursomc.domain.Categoria;
import com.silvioiwamoto.cursomc.repositories.CategoriaRepository;
import com.silvioiwamoto.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServices {

		@Autowired
		private CategoriaRepository repo;
		
		public Categoria buscar(Integer id) {
			Optional<Categoria> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}		
}
