package yte.intern.springdata.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String title;
    private String author;
    private Long age;
    private LocalDateTime publishDate;

}
