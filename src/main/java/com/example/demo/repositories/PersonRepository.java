package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Person;

import java.util.List;

public interface PersonRepository<P> extends CrudRepository<Person, Long> {
    List<Person> findByFirstName(String firstName);
    
    Person findByIdAndFirstName(Long Id,String firstname);
}
