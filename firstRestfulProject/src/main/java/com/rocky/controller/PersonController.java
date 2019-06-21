package com.rocky.controller;

import com.rocky.dao.PersonRepository;
import com.rocky.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "findPerson")
    public Object findPerson(Long id){
        return personRepository.findById(id);
    }

    @GetMapping(path = "findP")
    public List<Person> findPerson(String name, String address){
        return personRepository.withNameAndAddressQuery(name, address);
    }

    @GetMapping(path = "findwith")
    public Person findPersonWith(String name, String address){
        return personRepository.withNameAndAddressNamedQuery(name, address);
    }

    @PostMapping(path = "addPerson")
    public void addPerson(Person person){
        personRepository.save(person);
    }

    @DeleteMapping(path = "deletePerson")
    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

}
