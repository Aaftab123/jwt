package com.example.demo.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.response.PersonList;
import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;


@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Optional<Person> getAllUsers(@PathVariable Long id) {
		return personService.getById(id);
	}

	@RequestMapping(value = "/personByName/{name}", method = RequestMethod.GET)
	public List<Person> getPersoneByName(@PathVariable String name) {
		return personService.findByName(name);
	}
	
	@RequestMapping(value = "/personByName/{id}/{name}", method = RequestMethod.GET)
	public List<Person> getPersoneByIdAndName(@PathVariable Long id,@PathVariable String name) {
		return personService.findByName(name);
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonList getAll() {
		PersonList PersonList = new PersonList();
		PersonList.setPersonList(personService.getAllPersons());
		
		//stream teast
		Map<Long,Person> mapOfPerson = PersonList.getPersonList().stream().collect(Collectors.toMap(person -> person.getId(), person->person));
		PersonList.getPersonList().stream().map(a ->a.getId()).collect(Collectors.toList());
//		Predicate<String> predicate = s-> s.
		PersonList.getPersonList().stream().sorted();
		
		return PersonList;
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public HttpStatus deletePersnone(@PathVariable Long id) {
		personService.deletePerson(id);
		return HttpStatus.ACCEPTED;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public HttpStatus insertPersone(@RequestBody Person person) {
		return personService.addPerson(person) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public HttpStatus updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}
