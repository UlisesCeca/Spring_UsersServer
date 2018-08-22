package com.ulises.usersserver.constants;

public class Constants {
    public static final String REQUEST_ERROR_NOT_FOUND = "This endpoint doesn't exist.";
    public static final String REQUEST_ERROR_UNATHORIZED = "Either your username or password is incorrect or you are not " +
            "authorized to enter. Please, try again.";
    public static final String REQUEST_ERROR_INTERNAL_SERVER_ERROR = "There has been a server error and your request " +
            "couldn't be processed.";
    public static final String REQUEST_ERROR_NULL_BODY = "Request's body must not be null.";
    public static final String REQUEST_ERROR_USER_NOT_FOUND_WITH_EMAIL = "There is not any user with this email.";
    public static final String ENDPOINT_USERS = "/users";
    public static final String ENDPOINT_USERS_REGISTER_APP = "/register/app";
    public static final String ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL = "/recoverpasswordbyemail";
    public static final String ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL_ENTER = "/recoverpasswordfinal";
    public static final String REQUEST_ERROR_USER_DOESNT_EXIST = "Your information to enter is incorrect. Please, try " +
            "again.";
    public static final String REQUEST_ERROR_EMAIL_ALREADY_EXISTS = "There is someone registered with this email already.";
    public static final String REQUEST_ERROR_PHONE_ALREADY_EXISTS = "There is someone registered with this phone already.";
    public static final String REQUEST_ERROR_PASSWORDS_DONT_MATCH = "The introduced passwords don't match.";
    public static final String REQUEST_ERROR_USER_ALREADY_EXISTS = "There is someone registered with this username already.";
    public static final String REQUEST_ERROR_USER_ID_EXISTS = "There is someone registered with this ID already.";
    public static final String USERNAME_CONTEXT_KEY = "____@@123_d_www!!_ee2_E2-CON!!!!";
    public static final String ROLE_PREFIX = "ROLE_";
    public enum ROLES {
        ULIAPP, ULISES
    }
    public enum CONTEXTS {
        ULIAPP
    }
    public static final String ENDPOINT_RECOVER_PASSWORD = "http://localhost:8681/ulises/notificationsserver/notifications/email";
}
