package br.com.gilvanmuniz;

import br.com.gilvanmuniz.model.Person;
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

    // ----------------------  endpoint via o verbo GET --> List<Person> findAll() ----------------------------

    //adicionar todos os registros na lista
    public List<Person> findAll() {
        logger.info(" finding all people ");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i <= 8; i++) {
            Person person = mockPerson(i);
           persons.add(person);  // adicionar cada registro
        }
        return persons;

    }

    // --------------  endpoint via o verbo GET --> Person findById(String id)----------------------------
        // findById ---> busca por id
    public Person findById(String id){

        logger.info("Finding one Person");

       // vamos mock abaixo para testar temporaraiamente
        Person person = new Person();

        person.setId(count.incrementAndGet());
        person.setFirtsName("Gilvan");
        person.setLastName("Muniz");
        person.setAddress("Rua Tereza Bezerra Salustino, 1888 A, Lagoa Nova Natal/RN.");
        person.setGender("Masculino");

        return person;
    }


    // -------------------------------  endpoint via o verbo POST --> Person create(Person person)  ---------------------------------------
        // create ---> criar um regestro pessoa = person
    public Person create(Person person){

        logger.info(" creating one person ");

       // vamos mock abaixo para testar temporaraiamente


        return person;
    }

    // -------------------------------  endpoint via o verbo UPDATE --> Person update(Person person) ---------------------------------------

    public Person update(Person person){
        logger.info(" updating one person ");
        // vamos mock abaixo para testar temporarariamente
        return person;
    }

    // ----------------------  endpoint via o verbo DELETE --> void delete(String id)-------------------


    // não retona nada só executar o delete não retorna conteudo ele pode ser um viod
    public void delete(String id) {

        logger.info(" Deleting one Person ");

        // vamos mock abaixo para testar temporaraiamente

    }

    // ---------------------- parte de mock os dados --------------------------------------
    private Person mockPerson(int i) {
        logger.info(" list of people ");

        Person person = new Person();
        person.setId(count.incrementAndGet());
        person.setFirtsName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("Male");
        return person;

    }


}
