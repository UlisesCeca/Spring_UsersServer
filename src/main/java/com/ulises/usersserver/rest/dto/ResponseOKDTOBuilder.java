package com.ulises.usersserver.rest.dto;

public class ResponseOKDTOBuilder {
    private String message;

    public static ResponseOKDTOBuilder builder() {
        return new ResponseOKDTOBuilder();
    }

    public ResponseOKDTOBuilder message(final String message) {
        this.message = message;
        return this;
    }

    public ResponseOKDTO build() {
        final ResponseOKDTO dto = new ResponseOKDTO();
        dto.setMessage(this.message);
        return dto;
    }
}
