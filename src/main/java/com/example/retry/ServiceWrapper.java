package com.example.retry;

import org.springframework.stereotype.Service;

@Service
public class ServiceWrapper {

	private final RetryService retryService;
	
	public ServiceWrapper(RetryService retryService) {
		this.retryService = retryService;
	}
	
	public void callRetryServiceMethod1() throws Exception {
		System.out.println("calling retry service method1");
		retryService.retryWhenException("Sample Request");
		System.out.println("finisehd retry execution");
	}
}
