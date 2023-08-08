package yte.intern.springweb.resttemplate;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class xx {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final RestTemplate restTemplate = new RestTemplate();
//    @Test
//    public void testGetAllPosts() {
//        ResponseEntity<Post[]> response = restTemplate.getForEntity(baseUrl + "/posts", Post[].class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//
//        Post[] posts = response.getBody();
//        System.out.println(posts);
//        assertNotNull(posts);
//    }


    public static void main(String[] args) {
        getPosts();
        getPostById(2);
        addRandomPost();
        getPostsByUserId(2);
        updateComment(5L);
        deletePost(1);
    }

    public static void getPosts() {
        ResponseEntity<Post[]> response = restTemplate.getForEntity(BASE_URL + "/posts", Post[].class);
        Post[] posts = response.getBody();
        if (posts != null) {
            for (Post post : posts) {
                System.out.println(post);
                System.out.println("@@@@@@@@@@@@@@@");
            }
        }
    }

    public static void getPostById(int id) {
        ResponseEntity<Post> response = restTemplate.getForEntity(BASE_URL + "/posts/" + id, Post.class);
        Post post = response.getBody();
        if (post != null) {
            System.out.println(post);
        }
    }

    public static void addRandomPost() {
        Post newPost = new Post(1L, 0L, "New Post Title", "New post content...");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Post> request = new HttpEntity<>(newPost, headers);

        ResponseEntity<Post> response = restTemplate.postForEntity(BASE_URL + "/posts", request, Post.class);
        Post addedPost = response.getBody();
        if (addedPost != null) {
            System.out.println(addedPost);
        }
    }

    public static void getPostsByUserId(int userId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL + "/posts")
                .queryParam("userId", userId);

        ResponseEntity<Post[]> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Post[].class);
        Post[] posts = response.getBody();
        if (posts != null) {
            for (Post post : posts) {
                System.out.println(post);
                System.out.println("$$$$$$$$$$$$$$");
            }
        }
    }

    public static void updateComment(Long commentId) {
        Comment updatedComment = new Comment(commentId, 0L, "", "", "Updated comment body...");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Comment> request = new HttpEntity<>(updatedComment, headers);

        restTemplate.exchange(BASE_URL + "/comments/" + commentId, HttpMethod.PUT, request, Void.class);
        System.out.println("Comment " + commentId + " updated.");
    }

    public static void deletePost(int postId) {
        restTemplate.delete(BASE_URL + "/posts/" + postId);
        System.out.println("Post " + postId + " deleted.");
    }

}
