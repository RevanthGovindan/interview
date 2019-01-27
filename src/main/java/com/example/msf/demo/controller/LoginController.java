package com.example.msf.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.msf.demo.model.Login;
import com.example.msf.demo.repository.LoginRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class LoginController {
	private ObjectMapper mapper = new ObjectMapper();
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	LoginRepository loginRepository;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String admin(@RequestBody Login login) {
		Login res = hello(login);
		String password = login.getPassword();
		LOGGER.info(res.getPassword().toString());
		LOGGER.info(password);
		if( res != null) {
			LOGGER.info("came"	);
			if((res.getPassword().toString()).equals(password)) {
				LOGGER.info("came"	);
				return "{'isValid' :'true'}";
			}
			try {		 
				String jsonString = mapper.writeValueAsString(res);
							
				} catch(JsonProcessingException e) {
					e.printStackTrace();
				}
			
		}
		
		return "{'isValid' :'false'}";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save( Login login) {
		loginRepository.save(login);
	}
	
	public Login hello(Login login) {
		String name = login.getName();
		Login loggin = loginRepository.findOneByName(name);
		
		return loggin;
	}
}
