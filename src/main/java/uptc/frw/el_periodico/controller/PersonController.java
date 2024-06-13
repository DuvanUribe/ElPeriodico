package uptc.frw.el_periodico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import uptc.frw.el_periodico.jpa.entity.Person;
import uptc.frw.el_periodico.service.PersonService;


import java.util.List;


@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @QueryMapping(name = "findAllPerson")
    public List<Person> findAllPerson() {
        return personService.findAll();
    }

    @QueryMapping(name = "findPersonById")
    public Person findPersonById(@Argument(name = "id") Integer id) {
        return personService.findById(id);
    }

    @MutationMapping
    public Person createPerson(@Argument Person inputPerson) {
        return personService.createPerson(inputPerson);
    }

    @MutationMapping
    public Person updatePerson(@Argument Person inputPerson) {
        return personService.updatePerson(inputPerson);
    }

    @MutationMapping
    public String deletePerson(@Argument Integer id) {
        if (personService.findById(id) != null) {
            personService.deletePerson(id);
            return ("PERSONA ELIMINADA");
        }
        return ("NO SE ENCONTRO LA PERSONA SOLICITADA PARA ELIMINAR");
    }
}
