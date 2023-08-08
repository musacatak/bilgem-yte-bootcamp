package yte.intern.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import yte.intern.springweb.resttemplate.Post;

import yte.intern.springweb.resttemplate.Comment;

import java.net.URI;
import java.util.Arrays;

public class RestTemplateTest {

    RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    void getPosts() {

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);


        if (response.getBody() != null) {
            System.out.println(Arrays.stream(response.getBody()).toList());
        } else {
            System.out.println("Response body is null.");
        }


    }

    @Test
    void getSinglePost() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);

        System.out.println(response.getBody());
    }

    @Test
    void addPost() {

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Post> request = RequestEntity.post(uri).body(new Post(7L, null, "Kurt", "Kurtlar hebele hübeledir."));

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);

        System.out.println(response.getBody());

    }

    @Test
    void getPostId() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);



        if (response.getBody() != null) {
            System.out.println(Arrays.stream(response.getBody()).toList());
        } else {
            System.out.println("Response body is null.");
        }

    }

    @Test
    void updateComment() {

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("comments", "5")
                .build()
                .toUri();

        RequestEntity<Comment> request = RequestEntity.put(uri).body(
                new Comment(9L, 5L, "updatedName", "updatedMail@mail.com", "UpdatedBdy"));

        ResponseEntity<Comment> response = restTemplate.exchange(request, Comment.class);

        System.out.println(response.getBody());

    }

    @Test
    void delete() {

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts", "1")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.delete(uri).build();

        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);

        System.out.println(response.getBody());

    }

}
