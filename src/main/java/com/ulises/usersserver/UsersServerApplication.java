package com.ulises.usersserver;

import com.ulises.usersserver.rest.endpoints.UserEndpoint;
import com.ulises.usersserver.rest.exceptionsmappers.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsersServerApplication {
	public static void main(String[] args) {SpringApplication.run(UsersServerApplication.class, args);}

	@Bean
	public ResourceConfig jerseyConfig() {
		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(UserEndpoint.class);
		resourceConfig.register(UserNotFoundExceptionMapper.class);
		resourceConfig.register(NotFoundMapper.class);
		resourceConfig.register(InternalServerErrorMapper.class);
		resourceConfig.register(UserAlreadyExistsExceptionMapper.class);
		resourceConfig.register(ConstraintViolationMapper.class);
		resourceConfig.register(PasswordsDontMatchExceptionMapper.class);
		resourceConfig.register(TokenExpiredExceptionMapper.class);
		resourceConfig.register(TokenNotMatchExceptionMapper.class);
		resourceConfig.register(UserWithEmailAlreadyExistsExceptionMapper.class);

		return resourceConfig;
	}
}
