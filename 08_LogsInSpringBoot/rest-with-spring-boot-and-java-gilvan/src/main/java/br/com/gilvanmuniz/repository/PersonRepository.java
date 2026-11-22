package br.com.gilvanmuniz.repository;

import br.com.gilvanmuniz.model.Person;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
// o que devemos ter agora para ter as operações de CRUD temos que ter extends JpaRepository
//recebe 2 parametro <Person, Id> passa 2 tipos Person, Long
// com estas informações consegur fazer um CRUD basico
public interface PersonRepository extends JpaRepository<Person, Long> {}
