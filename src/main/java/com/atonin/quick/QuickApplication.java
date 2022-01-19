package com.atonin.quick;

import com.atonin.quick.model.Role;
import com.atonin.quick.model.User;
import com.atonin.quick.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class QuickApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Nurumbet Saryev","atonin","S3nur%R!",new ArrayList<>()));
			userService.saveUser(new User(null,"Kushtar Daminov","kushtar","S3fljdadfR!",new ArrayList<>()));
			userService.saveUser(new User(null,"Marat Doolatov","marat","jkfd$2%R!",new ArrayList<>()));
			userService.saveUser(new User(null,"Akzhol Kamalov","akjol","fdadfd%R!",new ArrayList<>()));

			userService.addRoleToUser("atonin","ROLE_USER");
			userService.addRoleToUser("kushtar","ROLE_MANAGER");
			userService.addRoleToUser("marat","ROLE_ADMIN");
			userService.addRoleToUser("akjol","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("akjol","ROLE_USER");
			userService.addRoleToUser("akjol","ROLE_ADMIN");
		};
	}

}
