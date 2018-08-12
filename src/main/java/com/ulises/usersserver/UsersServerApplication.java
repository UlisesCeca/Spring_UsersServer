package com.ulises.usersserver;

import com.ulises.usersserver.rest.endpoints.UserEndpoint;
import com.ulises.usersserver.rest.exceptionsmappers.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsersServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServerApplication.class, args);
	}

	@Bean
	public ResourceConfig jerseyConfig() {
		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(UserEndpoint.class);
		resourceConfig.register(UserNotFoundExceptionMapper.class);
		resourceConfig.register(NotFoundMapper.class);
		resourceConfig.register(InternalServerErrorMapper.class);
		resourceConfig.register(EmailAlreadyExistsExceptionMapper.class);
		resourceConfig.register(PhoneAlreadyExistsExceptionMapper.class);
		resourceConfig.register(UserAlreadyExistsExceptionMapper.class);
		resourceConfig.register(IDAlreadyExistsExceptionMapper.class);
		resourceConfig.register(WrongParameterExceptionMapper.class);
		resourceConfig.register(WrongBodyExceptionMapper.class);
		return resourceConfig;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
