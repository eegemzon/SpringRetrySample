package com.example.retry;

import java.time.LocalDateTime;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

	//dont use this counter on production, lol
	private static int COUNTER = 0; 

	@Retryable(value = { Exception.class }, 
			maxAttempts = 3, 
			backoff = @Backoff(delay=5000))
	public void retryWhenException(String request) throws Exception {
		System.out.println("Time invoked:" + LocalDateTime.now());
		COUNTER++;
		System.out.println("COUNTER = " + COUNTER);
		throw new RuntimeException("Cant connect");
	}

	@Recover
	public void recover(Throwable t, String request) {
		System.out.println("Recover method called...");
		System.out.println("Request : " + request);
		System.out.println("Error message : " + t.getMessage());
		System.out.println("Error Class :: " + t.getClass().getName());
	}

}
