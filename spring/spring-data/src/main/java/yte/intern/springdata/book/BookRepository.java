package yte.intern.springdata.book;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByTitle(String title);

    List<Book> findByAgeGreaterThan(Long age, Sort sort);

    List<Book> findByPublishDateAfter(LocalDateTime start, PageRequest pageRequest);

    List<Book> findByTitleContainsIgnoreCase(String keyword);

    List<Book> findByAuthorAndAgeGreaterThan(String author, Long age);

    long countByAuthor(String author);

    boolean existsByAuthor(String author);
}

