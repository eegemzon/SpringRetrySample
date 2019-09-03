package com.example.retry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private final ServiceWrapper serviceWrapper;
	
	public Controller(ServiceWrapper serviceWrapper) {
		this.serviceWrapper = serviceWrapper;
	}
	
	@GetMapping("/retry")
	public ResponseEntity<String> tryRetry() throws Exception {
		System.out.println("controller - calling serviceWrapper...");
		serviceWrapper.callRetryServiceMethod1();
		System.out.println("ok...");
		return ResponseEntity.ok("OK");
	}
}
