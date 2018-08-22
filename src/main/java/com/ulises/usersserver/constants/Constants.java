package com.ulises.usersserver.constants;

public class Constants {
    public static final String REQUEST_ERROR_NULL_BODY = "Request's body must not be null.";
    public static final String ENDPOINT_USERS = "/users";
    public static final String ENDPOINT_USERS_REGISTER_APP = "/register/app";
    public static final String ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL = "/recoverpasswordbyemail";
    public static final String ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL_ENTER = "/recoverpasswordfinal";
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
