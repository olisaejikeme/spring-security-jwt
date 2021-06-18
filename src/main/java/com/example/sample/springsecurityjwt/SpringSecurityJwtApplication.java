package com.example.sample.springsecurityjwt;

import com.example.sample.springsecurityjwt.models.User;
import com.example.sample.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}

/*@Component
class DemoCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user3 = new User();
		user3.setId(3L);
		user3.setName("Reggie");
		user3.setUsername("Reg");
		user3.setEmail("reggie@mail.com");
		user3.setPassword("qwerty");

		userRepository.save(user3);

		User user4 = new User();
		user4.setId(4L);
		user4.setName("Mary");
		user4.setUsername("Mary");
		user4.setEmail("mary@mail.com");
		user4.setPassword("mary");

		userRepository.save(user4);
	}
}
 */