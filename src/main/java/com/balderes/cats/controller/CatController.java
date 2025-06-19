package com.balderes.cats.controller;


import com.balderes.cats.api.CatApi;
import com.balderes.cats.entity.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController implements CatApi {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public String getCat() {
		Cat cat = new Cat("Baksi", 7, 6.);
		try {
			return objectMapper.writeValueAsString(cat);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String addCat(String name, Integer age, Double weight) {
		Cat cat = new Cat(name, age, weight);
		try {
			return objectMapper.writeValueAsString(cat);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
