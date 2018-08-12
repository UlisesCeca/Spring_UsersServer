package com.ulises.usersserver.services;

import com.ulises.usersserver.constants.Constants;
import com.ulises.usersserver.services.entities.User;
import com.ulises.usersserver.services.exceptions.*;
import com.ulises.usersserver.services.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public void register(User user, UriInfo uriInfo) {
        final String registrationType = uriInfo.getQueryParameters().getFirst("registrationType");

        this.checkRegisterBody(user, uriInfo);
        if(registrationType.equalsIgnoreCase(Constants.REGISTRATION_TYPE.USERNAME.toString()))
            this.registerByUsername(user);
        else if(registrationType.equalsIgnoreCase(Constants.REGISTRATION_TYPE.EMAIL.toString()))
            this.registerByEmail(user);
        else if(registrationType.equalsIgnoreCase(Constants.REGISTRATION_TYPE.ID.toString()))
            this.registerByID(user);
        else if(registrationType.equalsIgnoreCase(Constants.REGISTRATION_TYPE.PHONE.toString()))
            this.registerByPhone(user);
        else
            throw new WrongParameterException();
    }

    private void registerByEmail(User user) {
        user.setUsername(user.getEmail());

        if(this.userRepository.existsByEmailAndContext(user.getEmail(), user.getContext()))
            throw new EmailAlreadyExistsException();
        else if(user.getPhone() != null &&
                this.userRepository.existsByPhoneAndContext(user.getPhone(), user.getContext()))
            throw new PhoneAlreadyExistsException();
        else
            this.userRepository.insert(user);
    }

    private void registerByID(User user) {
        user.setUsername(user.getId());

        if(this.userRepository.existsByIdAndContext(user.getId(), user.getContext()))
            throw new IDAlreadyExistsException();
        else {
            checkEmailAndPhoneAndInsert(user);
        }
    }

    private void registerByUsername(User user) {
        if(this.userRepository.existsByUsernameAndContext(user.getUsername(), user.getContext()))
            throw new UserAlreadyExistsException();
        else checkEmailAndPhoneAndInsert(user);
    }

    private void checkEmailAndPhoneAndInsert(User user) {
        if(user.getEmail() != null &&
                this.userRepository.existsByEmailAndContext(user.getEmail(), user.getContext()))
            throw new EmailAlreadyExistsException();
        else if(user.getPhone() != null &&
                this.userRepository.existsByPhoneAndContext(user.getPhone(), user.getContext()))
            throw new PhoneAlreadyExistsException();
        else
            this.userRepository.insert(user);
    }

    private void registerByPhone(User user) {
        user.setUsername(user.getPhone());

        if(this.userRepository.existsByPhoneAndContext(user.getPhone(), user.getContext()))
            throw new PhoneAlreadyExistsException();
        else if(user.getEmail() != null &&
                this.userRepository.existsByEmailAndContext(user.getEmail(), user.getContext()))
            throw new EmailAlreadyExistsException();
        else
            this.userRepository.insert(user);
    }

    private void checkRegisterBody(final User user, final UriInfo uriInfo) {
        MultivaluedMap<String, String> params = uriInfo.getQueryParameters();

        if((params.getFirst("registrationType").equalsIgnoreCase("username") && user.getUsername() == null) ||
                (params.getFirst("registrationType").equalsIgnoreCase("email") && user.getEmail() == null) ||
                (params.getFirst("registrationType").equalsIgnoreCase("phone") && user.getPhone() == null) ||
                (params.getFirst("registrationType").equalsIgnoreCase("id") && user.getId() == null) ||
                (params.getFirst("name").equalsIgnoreCase("true") && user.getName() == null) ||
                (params.getFirst("surname").equalsIgnoreCase("true") && user.getSurname() == null) ||
                (params.getFirst("age").equalsIgnoreCase("true") && user.getAge() == 0) ||
                (params.getFirst("birth").equalsIgnoreCase("true") && user.getBirth() == null) ||
                (params.getFirst("address").equalsIgnoreCase("true") && user.getAddress() == null) ||
                (params.getFirst("addressCountry").equalsIgnoreCase("true") && user.getAddress().getCountry() == null) ||
                (params.getFirst("addressZipCode").equalsIgnoreCase("true") && user.getAddress().getZipCode() == null) ||
                (params.getFirst("addressProvince").equalsIgnoreCase("true") && user.getAddress().getProvince() == null) ||
                (params.getFirst("addressTown").equalsIgnoreCase("true") && user.getAddress().getTown() == null) ||
                (params.getFirst("addressStreet").equalsIgnoreCase("true") && user.getAddress().getStreet() == null) ||
                (params.getFirst("addressNumber").equalsIgnoreCase("true") && user.getAddress().getNumber() == null) ||
                (params.getFirst("addressGate").equalsIgnoreCase("true") && user.getAddress().getGate() == null) ||
                (params.getFirst("addressStairs").equalsIgnoreCase("true") && user.getAddress().getStairs() == null) ||
                (params.getFirst("addressFloor").equalsIgnoreCase("true") && user.getAddress().getFloor() == null) ||
                (params.getFirst("addressDoor").equalsIgnoreCase("true") && user.getAddress().getDoor() == null) ||
                (params.getFirst("context").equalsIgnoreCase("true") && user.getContext() == null) ||
                (params.getFirst("phone").equalsIgnoreCase("true") && user.getPhone() == null) ||
                (params.getFirst("email").equalsIgnoreCase("true") && user.getEmail() == null) ||
                (params.getFirst("context").equalsIgnoreCase("true") && user.getContext() == null) ||
                (params.getFirst("contextName").equalsIgnoreCase("true") && user.getContext().getName() == null))
            throw new WrongBodyException();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRole());
    }
}
