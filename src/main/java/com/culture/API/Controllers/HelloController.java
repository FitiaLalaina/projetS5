package com.culture.API.Controllers;





import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class HelloController  {

	private static final String template = "Hello, %s!";


	@GetMapping("/greeting")
	public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		return new ResponseEntity<>(String.format(template, name), HttpStatus.OK);
	}
}