package com.ulises.usersserver.rest.dto;

public class ErrorDTOBuilder {
    private String message;

    public static ErrorDTOBuilder builder() {
        return new ErrorDTOBuilder();
    }

    public ErrorDTOBuilder message(final String message) {
        this.message = message;
        return this;
    }

    public ErrorDTO build() {
        final ErrorDTO dto = new ErrorDTO();
        dto.setMessage(this.message);
        return dto;
    }
}
