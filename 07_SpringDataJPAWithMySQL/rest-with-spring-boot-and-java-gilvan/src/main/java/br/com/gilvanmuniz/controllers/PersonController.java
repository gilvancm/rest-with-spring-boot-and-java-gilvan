package br.com.gilvanmuniz.controllers;
import br.com.gilvanmuniz.exception.ResourceNotFoundException;
import br.com.gilvanmuniz.services.PersonServices;
import br.com.gilvanmuniz.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // para podermos explorar endpoint da aplicação
@RequestMapping("/person")   // nome do endpoint  /person  = caminho
public class PersonController {
    @Autowired
    private PersonServices service;   // INJEÇÂO DE DEPENDÊNCIA

    // ---------------------------- Via findAll --> Busca todos - Verbo --> GET  ------------------------------------------

    // o  URL vai ser http://localhost:8080/person
    // em outras versões usamos @RequestMapping(method = RequestMethod.GET,
    // mais agora melhorou usamos  é a mesma coisa com as melhoras
    // neste caso usa ai na linha abaixo anntattion @GetMapping melhora o
    // anotação do retorno  Status code --> ex: 200 ok
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE
    )

    public List<Person> findAll() {
        return service.findAll();

    }

    // ---------------------------- Via findById --> Busca o ID  - Verbo --> GET  ------------------------------------------

    // o  URL vai ser http://localhost:8080/person/1
    @GetMapping(value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE

    )

     public Person findById(@PathVariable("id") Long id){

        return service.findById(id);

    }

    // ---------------------------- Via create - Verbo --> POST ------------------------------------------
    // o  URL vai ser http://localhost:8080/person -- criar no registro
    @PostMapping(
                  consumes = MediaType.APPLICATION_JSON_VALUE,
                  produces = MediaType.APPLICATION_JSON_VALUE
    )

     public Person create(@RequestBody Person person){
        return service.create(person);
    }
            //  URL -->  http://localhost:8080/person
    //criar novo registro exemplo sem cochet e sem id

    // executa no BODY
    /*
    *  {
        "firtsName": "Lucas Emanuel",
        "lastName": "Muniz",
        "address": "Rua Tereza Bezerra Salustino 1888 A, Lagoa Nova Natal RN - Brasil",
        "gender": "Male"
    }
    * */

    // ---------------------------- Via UPDATE - Verbo --> PUT ------------------------------------------
    //  URL -->  http://localhost:8080/person
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
   )

    public Person update(@RequestBody Person person){ return service.update(person);

    }
     // executa no BODY
    /*
    {
        "id": 1,
        "firtsName": "Gilvan",
        "lastName": "Muniz",
        "address": "Rua Tereza Bezerra Salustino 1888 A, Lagoa Nova Natal RN - Brasil",
        "gender": "Male"
    }

   */
    // ---------------------------- Via dalete - Verbo --> DELETE ------------------------------------------

    //  URL -->  http://localhost:8080/person/numId
    // ex: http://localhost:8080/person/1  // passa só Id
    @DeleteMapping(value = "/{id}")

    /*   // vamos melhorar a resposta do delete vai ser 204 ok
    public void delete(@PathVariable("id") Long id){service.delete(id);
        //delete não retorna nada
    }
    */
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
