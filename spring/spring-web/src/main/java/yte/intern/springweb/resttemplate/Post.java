package yte.intern.springweb.resttemplate;

public record Post(
        Long userId,
        Long id,
        String title,
        String body
) {
}
