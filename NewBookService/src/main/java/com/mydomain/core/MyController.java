package com.mydomain.core;

import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
JSONParser parser = new JSONParser();
	
	@RequestMapping("/books")
	public JSONArray getBooks() throws IOException, ParseException{
		JSONArray arr=(JSONArray) parser.parse(new InputStreamReader(MyController.class.getResourceAsStream("/books.json")));
		return arr;
	}
}
