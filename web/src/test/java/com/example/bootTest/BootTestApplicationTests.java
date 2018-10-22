package com.example.bootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootTestApplicationTests {

	@Test
	public void contextLoads() {
		UserDetails user = User.withDefaultPasswordEncoder()
						.username("user")
						.password("aa")
						.roles("user")
						.build();
		System.out.println(user.getPassword());
	}

}
