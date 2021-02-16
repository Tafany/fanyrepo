package com.muxi.ApiRestMuxi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.muxi.api.muxi.service.TerminalService;

@SpringBootTest
class ApiRestMuxiApplicationTests {

	@Autowired // ingetando servico
	TerminalService service;


	@Test
	public void salvarTest() {
		Assert.isNull(service.save(null),"Retornou null");
		
	}
}
