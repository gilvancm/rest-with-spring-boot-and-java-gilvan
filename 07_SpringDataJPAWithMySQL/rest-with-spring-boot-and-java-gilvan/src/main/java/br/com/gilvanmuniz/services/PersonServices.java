package br.com.gilvanmuniz.services;

import br.com.gilvanmuniz.exception.ResourceNotFoundException;
import br.com.gilvanmuniz.model.Person;
import br.com.gilvanmuniz.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

//trabalhamos com endpoint tipo get até agora atravez do navegador
// acessando o endpoint via GET via browse   verbo GET

@Service       //@Service  para este cara fique disponivel para
// injetar ele em outra classe
// e eu poder injetar de onde eu estiver
public class PersonServices {
    //oque vai ter as operações de cadastrar uma person = pessoa
   // vou lá numa classe controler GreetingController pegar o moco de contador
    private final AtomicLong count = new AtomicLong();  // contador

         // logger 	-----> registrador
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    //o logger severpara  acummula(guarda) dados importante da aplicação

    @Autowired    // feita a injeção de dependência
     PersonRepository repository;

    // ----------------------  endpoint via o verbo GET --> List<Person> findAll() ----------------------------

    //adicionar todos os registros na lista
    public List<Person> findAll() {
        logger.info(" finding all people ");
        return repository.findAll();
    }

    // --------------  endpoint via o verbo GET --> Person findById(String id)----------------------------
        // findById ---> busca por id
    public Person findById(Long id){

        logger.info("Finding one Person");
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this Id!"));

    }

    // -------------------------------  endpoint o verbo POST --> Person create(Person person)  ---------------------------------------

        // create ---> criar um regestro pessoa = person
    public Person create(Person person){

        logger.info(" creating one person ");

       // vamos mock abaixo para testar temporaraiamente

       return repository.save(person);


    }

    // -------------------------------  endpoint via o verbo UPDATE --> Person update(Person person) ---------------------------------------

    public Person update(Person person){
        logger.info(" updating one person ");

        Person entity = repository.findById(person.getId())
                 .orElseThrow(() -> new ResourceNotFoundException("No records found for the Id!"));
          // o id não precisa o banco se encarrega de colocar
        entity.setFirtsName(person.getFirtsName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setGender(person.getGender());

        return repository.save(person);

    }

    // ----------------------  endpoint via o verbo DELETE --> void delete(String id)-------------------


    // não retona nada só executar o delete não retorna conteudo ele pode ser um viod
    public void delete(Long id) {

        logger.info(" Deleting one Person ");

    Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this Id!"));
           repository.delete(entity);

    }



}
