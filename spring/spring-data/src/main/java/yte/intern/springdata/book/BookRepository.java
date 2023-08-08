package yte.intern.springdata.book;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);

    List<Book> findByAgeGreaterThan(@Param("age") Long age, Sort sort);

    List<Book> findByPublishDateAfter(LocalDateTime start, PageRequest pageRequest);

    List<Book> findByTitleContainsIgnoreCase(@Param("keyword") String keyword);

    List<Book> findByAuthorAndAgeGreaterThan(String author, Long age);

    long countByAuthor(String author);

    boolean existsByAuthor(String author);


    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Book findByTitleQuery(String title);

    @Query("SELECT b FROM Book b WHERE b.age >= :age ORDER BY b.age ASC")
    List<Book> findByAgeGreaterThanQuery(@Param("age") Long age, Sort sort);

    @Query("SELECT b FROM Book b WHERE b.publishDate > ?1")
    List<Book> findByPublishDateAfterQuery(LocalDateTime start, PageRequest pageRequest);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Book> findByTitleContainsIgnoreCaseQuery(@Param("keyword") String keyword);

    @Query("SELECT b FROM Book b WHERE b.author = ?1 AND b.age > ?2")
    List<Book> findByAuthorAndAgeGreaterThanQuery(String author, Long age);

    @Query("SELECT COUNT(b) FROM Book b WHERE b.author = ?1")
    long countByAuthorQuery(String author);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Book b WHERE b.author = ?1")
    boolean existsByAuthorQuery(String author);
}

