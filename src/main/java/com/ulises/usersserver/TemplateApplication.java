package com.ulises.usersserver;

import com.ulises.usersserver.rest.endpoints.UserEndpoint;
import com.ulises.usersserver.rest.exceptionsmappers.*;
import com.ulises.usersserver.services.exceptions.EmailAlreadyExistsException;
import com.ulises.usersserver.services.exceptions.PhoneAlreadyExistsException;
import com.ulises.usersserver.services.exceptions.UserAlreadyExistsException;
import com.ulises.usersserver.services.exceptions.UserIsEmptyException;
import org.glassfish.jersey.server.ResourceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
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
		resourceConfig.register(UserIsEmptyException.class);
		return resourceConfig;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
