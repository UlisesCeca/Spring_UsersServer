package com.ulises.usersserver.constants;

public final class Constants {
    public static final String REQUEST_ERROR_NULL_BODY = "Request's body must not be null.";

    public static final String ENDPOINT_USERS = "/users";
    public static final String ENDPOINT_USERS_REGISTER_APP = "/register/app";
    public static final String ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL_1 = "/recoverPasswordByEmailStep1";
    public static final String ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL_2 = "/recoverPasswordByEmailStep2";

    public static final String USERNAME_CONTEXT_KEY = "____@@123_d_www!!_ee2_E2-CON!!!!";

    public static final String ROLE_PREFIX = "ROLE_";

    public static final String ROLE_ULISES = "ULISES";
    public static final String ROLE_ULIAPP = "ULIAPP";

    public static final String CONTEXT_NAME_ULIAPP = "ULIAPP";
    public static final String APP_NAME_ULIAPP = "Uli App";

    public static final String ENDPOINT_RECOVER_PASSWORD = "http://localhost:8681/ulises/notificationsserver/notifications/email";
}
