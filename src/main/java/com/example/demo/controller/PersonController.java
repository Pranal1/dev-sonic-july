package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age,
			@RequestParam long mobile) {
		try {
					
		Person p = personService.create(firstName, lastName, age, mobile);
		
			return p.toString();
		
		} catch (NullPointerException e) {
			//e.printStackTrace();
			return "Data already in the system";
		}
	
		
	}
	//get?mobile=
	@RequestMapping("/get")
	public Person getPerson(@RequestParam long mobile) {
		return personService.getByFirstName(mobile);
	}
	@RequestMapping("/getAll")
	public List<Person> getAll(){
		return personService.getAll();
	}
	@RequestMapping("/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age,
			@RequestParam long mobile) {
		Person p = personService.update(firstName, lastName, age, mobile);
		return p.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam long mobile) {
		personService.delete(mobile);
		return "Deleted "+mobile;
	}
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		return "Deleted all records";
	}

}
