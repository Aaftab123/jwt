package com.example.demo.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.StudentRepository;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("getall")
	ResponseEntity<Object> getStudentDetails(HttpServletRequest httpServletRequest){
		
		ResponseEntity<Object> returnresp = new ResponseEntity<Object>(studentRepository.findAll(), HttpStatus.OK); 
		
		//studentRepository.findAll();
		return returnresp;
		
		
	}
	
}
