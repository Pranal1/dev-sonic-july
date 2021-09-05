package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	// Create operation
	public Person create(String firstName, String lastName, int age,long mobile) {
		Person p = personRepository.findByMobile(mobile);
		
		if(p == null) {
			return personRepository.save(new Person(firstName, lastName, age, mobile));
		}else{
			System.out.println("p else  > "+p.getFirstName());
			return null;
		}
			
	}

	// Retrieve operation
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	public Person getByFirstName(long mobile) {
		return personRepository.findByMobile(mobile);
	}

	// Update operation 
	public Person update(String firstName, String lastName, int age,long mobile) {
		Person p = personRepository.findByMobile(mobile);
		p.setMobile(mobile);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		
		return personRepository.save(p);
	}

	// Delete operation
	public void deleteAll() {
		personRepository.deleteAll();
	}

	public void delete(long mobile) {
		Person p = personRepository.findByMobile(mobile);
		personRepository.delete(p);
	}

}
