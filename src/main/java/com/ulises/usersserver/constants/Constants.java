package com.ulises.usersserver.constants;

public class Constants {
    public static final String REQUEST_ERROR_NOT_FOUND = "This endpoint doesn't exist.";
    public static final String REQUEST_ERROR_INTERNAL_SERVER_ERROR = "There has been a server error and your request " +
            "couldn't be processed.";
    public static final String REQUEST_ERROR_NULL_BODY = "Request's body must not be null.";
    public static final String RESPONSE_OK_USER_CREATED = "Your user has been created successfully.";
    public static final String ENDPOINT_USERS = "/users";
    public static final String ENDPOINT_USERS_REGISTER_APP = "/register/app";
    public static final String REQUEST_ERROR_USER_DOESNT_EXIST = "Your information to enter is incorrect. Please, try " +
            "again.";
    public static final String REQUEST_ERROR_EMAIL_ALREADY_EXISTS = "There is someone registered with this email already.";
    public static final String REQUEST_ERROR_PHONE_ALREADY_EXISTS = "There is someone registered with this phone already.";
    public static final String REQUEST_ERROR_USER_ALREADY_EXISTS = "There is someone registered with this username already.";
    public static final String REQUEST_ERROR_USER_ID_EXISTS = "There is someone registered with this ID already.";
    public static final String USERNAME_CONTEXT_KEY = "@@@uli";
}
