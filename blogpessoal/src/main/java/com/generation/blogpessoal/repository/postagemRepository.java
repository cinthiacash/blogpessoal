 package com.generation.blogpessoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.blogpessoal.model.postagem;

@Repository
public interface postagemRepository extends JpaRepository<postagem, Long> {
	public List<postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
