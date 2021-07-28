package com.example.demo;

import java.util.concurrent.CompletableFuture;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;



@Service
public class GitHubLookupService {

	Logger logger = org.slf4j.LoggerFactory.getLogger(GitHubLookupService.class);
	
	private final RestTemplate restTemplate;
	
	public GitHubLookupService(RestTemplateBuilder restTemplateBuilder)
	{
		this.restTemplate = restTemplateBuilder.build();
		
	}
	
	@Async
	public CompletableFuture<User> findUser(String user) throws InterruptedException{
		
		logger.info("Looking up "+ user);
		
		String url = String.format("https://api.github.com/users/%s", user);
		User results = restTemplate.getForObject(url, User.class);
		
		Thread.sleep(1000L); //1000ms delay for demo
		return CompletableFuture.completedFuture(results);
		
	}
}
