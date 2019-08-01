package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import springboot.junit.dao.PersonRepository;
import springboot.learn.bean.Person;

public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    
    @GetMapping("/") 
    public List<Person> getPersonList() { 
        return personRepository.findAll();
    } 
  
    @PostMapping("/") 
    public String postPerson(@ModelAttribute Person person) { 
        personRepository.save(person);
        return "success"; 
    } 
  
    @GetMapping("/{id}") 
    public Person getPerson(@PathVariable String id) { 
        return personRepository.getOne(id);
    } 
  
    @PutMapping("/{id}") 
    public String putPerson(@PathVariable String id, @ModelAttribute Person user) { 
        Person p = personRepository.getOne(id);
        p.setName(user.getName()); 
        p.setAge(user.getAge()); 
        personRepository.save(p);
        return "success"; 
    } 
  
    @DeleteMapping("/{id}") 
    public String deletePerson(@PathVariable String id) { 
        personRepository.deleteById(id);
        return "success"; 
    } 
}
