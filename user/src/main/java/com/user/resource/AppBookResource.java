package com.appbook.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.appbook.service.PersonService;

import com.appbook.pojo.PersonReqPojo;

@RestController
public class AppBookResource {

	@Autowired
	private PersonService personService;

	@PostMapping(value = "/addperson", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> addPerson(HttpServletRequest req, @RequestBody PersonReqPojo personReqPojo)
			throws Exception {

		return personService.addPerson(req, personReqPojo);

	}

	@GetMapping(value = "/findperson/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findperson(HttpServletRequest req, @PathVariable("id") String id) throws Exception {

		return personService.findPerson(req, id);

	}

}