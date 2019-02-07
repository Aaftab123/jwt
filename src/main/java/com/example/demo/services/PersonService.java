package com.example.demo.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;

class Person1
{
    public Person1(Integer id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }
 
    private Integer id;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	private String fname;
    private String lname;
 
    //Getters and Setters
 
    @Override
    public String toString() {
        return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
    }
}

@Service
public class PersonService {

	@Autowired
	PersonRepository<Person> personRepository;

	@Transactional
	public List<Person> getAllPersons() {
		Person1 lokesh = new Person1(1, "Lokesh", "Gupta");
        Person1 brian = new Person1(2, "Brian", "Clooney");
        Person1 alex = new Person1(3, "Alex", "Kolen");
         
        //Add some random persons
        Collection<Person1> list = Arrays.asList(lokesh,alex,brian);
        //list.stream().sorted();
        List<Person1> list1 = list.stream().sorted(Comparator.comparing(p -> p.getFname(),Comparator.reverseOrder())).collect(Collectors.toList());
		return (List<Person>) personRepository.findAll();
	}

	public List<Person> findByName(String name) {
		return personRepository.findByFirstName(name);
	}
	
	public Person findByIdAndName(Long id,String name) {
		return personRepository.findByIdAndFirstName(id, name);
	}

	public Optional<Person> getById(Long id) {
		return personRepository.findById(id);
	}

	@Transactional
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}

	@Transactional
	public boolean addPerson(Person person) {
		return personRepository.save(person) != null;
	}

	@Transactional
	public boolean updatePerson(Person person) {
		Optional<Person> isperson = null;
		if(person != null && person.getId() != null) {
			 isperson = personRepository.findById(person.getId());
		}
		if(isperson.isPresent()) {
			return personRepository.save(person) != null;
		}
		return false;
		
	}
}

