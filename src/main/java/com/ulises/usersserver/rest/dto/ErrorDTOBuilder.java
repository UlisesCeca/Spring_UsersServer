package com.ulises.usersserver.rest.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorDTOBuilder {
    private String message;
    private List<String> messages;

    private ErrorDTOBuilder() {
        messages = new ArrayList<>();
    }

    public static ErrorDTOBuilder builder() { return new ErrorDTOBuilder(); }

    public ErrorDTOBuilder message(final String message) {
        this.message = message;
        return this;
    }

    public ErrorDTOBuilder addMessage(final String message) {
        this.messages.add(message);
        return this;
    }

    public ErrorDTO build() {
        final ErrorDTO dto = new ErrorDTO();
        dto.setMessage(this.message);
        if(this.messages.size() > 0)
            dto.setMessages(this.messages);
        return dto;
    }
}
