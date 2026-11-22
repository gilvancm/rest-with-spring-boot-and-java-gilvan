package br.com.gilvanmuniz.controllers;


import br.com.gilvanmuniz.PersonServices;
import br.com.gilvanmuniz.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // para podermos explorar endpoint da aplicação
@RequestMapping("/person")   // nome do endpoint  /person  = caminho
public class PersonController {
    // podendo injetar algo da classe atraves da annotation @Service
    //injeta atravez da injeção de dependência
   // private PersonServices service = new PersonServices(); // antes era assim

    @Autowired  // com @Autowired é do SpringFramework onde ele traz componetes, se encarrega de criar a instância
    //agora no Spring Boot na linha abaixo
    private PersonServices service;   // INJEÇÂO DE DEPENDÊNCIA

    // ---------------------------- Via findAll --> Busca todos - Verbo --> GET  ------------------------------------------

    // o  URL vai ser http://localhost:8080/person
   // lista todos os registros
   //  @RequestMapping // receber uma parametro via path
    @RequestMapping(method = RequestMethod.GET,  //  method é outros tipos de verbo
                    produces = MediaType.APPLICATION_JSON_VALUE // produces  é outros tipos de verbo
    // lista todos os registros

    )

    public List<Person> findAll() {
        return service.findAll();

    }


    // ---------------------------- Via findById --> Busca o ID  - Verbo --> GET  ------------------------------------------

    // o  URL vai ser http://localhost:8080/person/1
    // lista o registro pelo id
    @RequestMapping(value = "/{id}",  // receber uma parametro via path
        method = RequestMethod.GET,           //  method é outros tipos de verbo
        produces = MediaType.APPLICATION_JSON_VALUE   // produces  é outros tipos de verbo

    )

     public Person findById(@PathVariable("id") String id){

        return service.findById(id);
    }


    // ---------------------------- Via create - Verbo --> POST ------------------------------------------
    // o  URL vai ser http://localhost:8080/person -- criar no registro
    //  no create é POST passamos pelo Body os dados em o id ou autoincremento já faz
    // lista o registro pelo id
    @RequestMapping(
                  method = RequestMethod.POST,           //  method é outros tipos de verbo
                  consumes = MediaType.APPLICATION_JSON_VALUE, // neste caso é bom usar // quando o suegue
        // for gerar a documentação vai precisar
                  produces = MediaType.APPLICATION_JSON_VALUE   // produces  é outros tipos de verbo
       // este metoodos são do springframworks
    )
      // lembre do @RequestBody pra retornar os registros
     public Person create(@RequestBody Person person){
        return service.create(person);
    }

    // obs que o id veio nulo, o responsável pelo id é o banco

    /*
    * {
    //  "id": 1,
    "firtsName": "Sandra",
    "lastName": "Muniz Barbosa",
    "address": "Rua Tereza Bezerra Salustino, 1888 A, Lagoa Nova Natal/RN.",
    "gender": "Masculino"
}
    *
    *
    * */

    // ---------------------------- Via update - Verbo -->  PUT  ------------------------------------------
  // http://localhost:8080/person
    // obs que o id no UPDATE tenho que passamos no Body o id.
    //o  URL vai ser http://localhost:8080/person
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
   )
    public Person update(@RequestBody Person person){
        return service.update(person);
    }
     //  tem que testar no Body
    /*
    * {
    "id": 1,
    "firtsName": "Sandra",
    "lastName": "Muniz Barbosa",
    "address": "Rua Tereza Bezerra Salustino, 1888 A, Lagoa Nova Natal/RN.",
    "gender": "Masculino"
}
    *
    *
    * */


    // ---------------------------- Via DELETE - Verbo --> DELETE ------------------------------------------

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE
          //  consumes = MediaType.APPLICATION_JSON_VALUE,  // delete não consome JSON
          //  produces = MediaType.APPLICATION_JSON_VALUE
   )
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }

}
