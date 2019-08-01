package springboot.junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.junit.service.PersonService;
import springboot.learn.bean.Person;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/personJdbc")
    public Person getPersonJdbc(String id) {
        return personService.getPersonFromDatabase(id);
    }

    @GetMapping("/personJpa")
    public Person getPersonJpa(String id) {
        return personService.getPersonUseJpa(id);
    }
}
