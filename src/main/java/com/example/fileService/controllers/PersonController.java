package com.example.fileService.controllers;

import com.example.fileService.models.Person;
import com.example.fileService.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    // INDEX: Get all people:
    @GetMapping(value = "/person")
    public ResponseEntity<List<Person>> getAllPeople(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    // SHOW: Get a specific person by id:
    @GetMapping(value = "/person/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            return new ResponseEntity<>(optionalPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optionalPerson, HttpStatus.NOT_FOUND);
        }
    }

    // CREATE: Add a new person:
    @PostMapping(value = "/person")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

}
