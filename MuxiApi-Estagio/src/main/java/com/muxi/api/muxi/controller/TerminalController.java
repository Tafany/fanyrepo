package com.muxi.api.muxi.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.muxi.api.muxi.enumerado.EnumJson;
import com.muxi.api.muxi.model.Message;
import com.muxi.api.muxi.model.Terminal;
import com.muxi.api.muxi.service.TerminalService;
import com.muxi.api.muxi.util.Util;

@RestController // Define a aplicacacao com uma aplicacao rest
@RequestMapping(value = "/rest/v1")
public class TerminalController { // http//localhost:8080/rest/v1/{endpoint=terminal}

	Message response = null;

	@Autowired
	TerminalService service;

	@PostMapping(value = { "/terminal" }, consumes = { "text/html; charset=UTF-8" }, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<String> save(@RequestBody String body) {
		try {

			JSONObject jsonObj = new Util().stringToJson(body.split(";"));
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Terminal terminal = null;
			terminal = mapper.readValue(jsonObj.toString(), Terminal.class);
			service.save(terminal);
			
			return ResponseEntity.ok().body(jsonObj.toString());
			

		} catch (Exception e) {
			messageStatus("an error occurred saving record", HttpStatus.INTERNAL_SERVER_ERROR.value());
			return ResponseEntity.badRequest().body("an error occurred saving record");
		}


	}

	private void messageStatus(String msg, int status) {
		Message response = new Message();
		response.setMensagem(msg);
		response.setStatusCode(status);
	}

	@GetMapping(path = "list",  produces = {MediaType.APPLICATION_JSON_VALUE })
	public List<Terminal> findAll() {
		try {
			return service.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(path = "/terminal/id/{logic}")
	public Terminal findId(@PathVariable(name = "logic", required = true) Integer logic) {
		try {
			return service.findId(logic);
		} catch (Exception e) {
			return null;
		}

	}

	@DeleteMapping(path = "/terminal/delete/{logic}")
	public boolean delete(@PathVariable(name = "logic", required = true) Integer logic) {
		try {
			service.delete(logic);
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	@PutMapping(path = "terminal/update/{logic}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Terminal update(@PathVariable(name = "logic", required = true) Integer logic,
			@RequestBody Terminal terminal) {
		try {
			return service.update(logic, terminal);
		} catch (Exception e) {
			return null;
		}

	}

}
