package com.volodymyr.training;

import com.volodymyr.training.db.DumbDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestStudyingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestStudyingApplication.class, args);
		DumbDB dumbDB = new DumbDB();
	}

}
