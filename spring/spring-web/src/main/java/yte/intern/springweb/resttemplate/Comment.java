package yte.intern.springweb.resttemplate;


public record Comment(
        Long postId,
        Long id,
        String name,
        String email,
        String body

) {
}