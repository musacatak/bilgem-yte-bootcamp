package yte.intern.springapp.common.response;

public record MessageResponse(
        String message,
        MessageType messageType
) {
}
