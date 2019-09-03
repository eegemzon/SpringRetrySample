package com.example.retry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private final RetryService retryService;
	
	public Controller(RetryService retryService) {
		this.retryService = retryService;
	}
	
	@GetMapping("/retry")
	public ResponseEntity<String> tryRetry() throws Exception {
		System.out.println("controller - calling serviceWrapper...");
		retryService.retryWhenException("something");
		//serviceWrapper.callRetryServiceMethod1();
		System.out.println("ok...");
		return ResponseEntity.ok("OK");
	}
}
