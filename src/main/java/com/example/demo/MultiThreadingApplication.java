package com.example.demo;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAsync
public class MultiThreadingApplication  {

	public static void main(String[] args) {

		//close application context to shut down custom ExecutorService (if not defined Spring creates default executor)
		SpringApplication.run(MultiThreadingApplication.class, args).close();;
	}

	

}
