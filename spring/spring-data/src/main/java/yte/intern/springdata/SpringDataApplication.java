package yte.intern.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.data.domain.*;

import yte.intern.springdata.book.Book;
import yte.intern.springdata.book.BookRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);

        BookRepository bookRepository = context.getBean(BookRepository.class);

        saveBooks(bookRepository);

        printBookRepository(bookRepository);

        printBookRepositoryWithQuery(bookRepository);


    }

    public static void printBookRepository(BookRepository bookRepository) {

        Book bookByTitle = bookRepository.findByTitle("Domain Driven Design");
        System.out.println("Book with title 'Domain Driven Design': " + bookByTitle);


        List<Book> booksWithAgeAbove15 = bookRepository.findByAgeGreaterThan(15L, Sort.by("age").ascending());
        System.out.println("Books with age >= 15 ordered by age: " + booksWithAgeAbove15);

        List<Book> booksAfter2000 = bookRepository.findByPublishDateAfter(
                LocalDateTime.parse("2000-01-01T00:00"), PageRequest.of(1, 5));

        System.out.println("Books published after 2000, page 2:" + booksAfter2000);

        List<Book> booksWithClean = bookRepository.findByTitleContainsIgnoreCase("Clean");
        System.out.println("Books with 'Clean' in title: " + booksWithClean);

        List<Book> booksByRobertCMartin = bookRepository.findByAuthorAndAgeGreaterThan("Robert C. Martin", 10L);
        System.out.println("Books by Robert C. Martin with age > 10: " + booksByRobertCMartin);


        long kentBeckBookCount = bookRepository.countByAuthor("Kent Beck");
        System.out.println("Number of books by Kent Beck: " + kentBeckBookCount);

        boolean hasMartinFowlerBooks = bookRepository.existsByAuthor("Martin Fowler");
        System.out.println("Has books by Martin Fowler: " + hasMartinFowlerBooks);

    }

    public static void printBookRepositoryWithQuery(BookRepository bookRepository) {

        System.out.println("@@@@@ printQueriesWith Query Annotation @@@@@");

        System.out.println("Book with title 'Domain Driven Design': " +
                bookRepository.findByTitleQuery("Domain Driven Design"));

        System.out.println("Books with age >= 15 ordered by age: " +
                bookRepository.findByAgeGreaterThanQuery(15L, Sort.by("age").ascending()));

        System.out.println("Books published after 2000, page 2:" + bookRepository.findByPublishDateAfterQuery(
                LocalDateTime.parse("2000-01-01T00:00"), PageRequest.of(1, 5)));

        System.out.println("Books with 'Clean' in title: " +
                bookRepository.findByTitleContainsIgnoreCaseQuery("Clean"));

        System.out.println("Books by Robert C. Martin with age > 10: " +
                bookRepository.findByAuthorAndAgeGreaterThanQuery("Robert C. Martin", 10L));


        System.out.println("Number of books by Kent Beck: " + bookRepository.countByAuthorQuery("Kent Beck"));

        System.out.println("Has books by Martin Fowler: " + bookRepository.existsByAuthorQuery("Martin Fowler"));

    }


    protected static void saveBooks(BookRepository bookRepository) {
        List<Book> exampleBooks = new ArrayList<>();

        exampleBooks.add(new Book(null, "Clean Code", "Robert C. Martin", 11L, LocalDateTime.parse("2008-07-11T00:00")));
        exampleBooks.add(new Book(null, "Clean Agile", "Robert C. Martin", 0L, LocalDateTime.parse("2019-09-12T00:00")));
        exampleBooks.add(new Book(null, "Agile Software Development", "Robert C. Martin", 17L, LocalDateTime.parse("2002-10-25T00:00")));
        exampleBooks.add(new Book(null, "Code Complete 2", "Steve McConnell", 26L, LocalDateTime.parse("1993-05-30T00:00")));
        exampleBooks.add(new Book(null, "Essential Scrum", "Kenneth S. Rubin", 7L, LocalDateTime.parse("2012-07-20T00:00")));
        exampleBooks.add(new Book(null, "Design Patterns", "Gang of Four", 25L, LocalDateTime.parse("1994-10-01T00:00")));
        exampleBooks.add(new Book(null, "Domain Driven Design", "Eric Evans", 16L, LocalDateTime.parse("2003-08-30T00:00")));
        exampleBooks.add(new Book(null, "Test Driven Development", "Kent Beck", 17L, LocalDateTime.parse("2002-11-18T00:00")));
        exampleBooks.add(new Book(null, "Refactoring", "Kent Beck", 7L, LocalDateTime.parse("2012-03-09T00:00")));
        exampleBooks.add(new Book(null, "Extreme Programming Explained", "Kent Beck", 15L, LocalDateTime.parse("2004-11-26T00:00")));

        bookRepository.saveAll(exampleBooks);
    }
}
//    @Bean
//    public CommandLineRunner initData(BookRepository bookRepository) {
//        return args -> {
//            List<Book> exampleBooks = new ArrayList<>();
//            exampleBooks.add(new Book(null, "Clean Code", "Robert C. Martin", 11L, LocalDateTime.parse("2008-07-11T00:00")));
//            exampleBooks.add(new Book(null, "Clean Agile", "Robert C. Martin", 0L, LocalDateTime.parse("2019-09-12T00:00")));
//            exampleBooks.add(new Book(null, "Agile Software Development", "Robert C. Martin", 17L, LocalDateTime.parse("2002-10-25T00:00")));
//            exampleBooks.add(new Book(null, "Code Complete 2", "Steve McConnell", 26L, LocalDateTime.parse("1993-05-30T00:00")));
//            exampleBooks.add(new Book(null, "Essential Scrum", "Kenneth S. Rubin", 7L, LocalDateTime.parse("2012-07-20T00:00")));
//            exampleBooks.add(new Book(null, "Design Patterns", "Gang of Four", 25L, LocalDateTime.parse("1994-10-01T00:00")));
//            exampleBooks.add(new Book(null, "Domain Driven Design", "Eric Evans", 16L, LocalDateTime.parse("2003-08-30T00:00")));
//            exampleBooks.add(new Book(null, "Test Driven Development", "Kent Beck", 17L, LocalDateTime.parse("2002-11-18T00:00")));
//            exampleBooks.add(new Book(null, "Refactoring", "Kent Beck", 7L, LocalDateTime.parse("2012-03-09T00:00")));
//            exampleBooks.add(new Book(null, "Extreme Programming Explained", "Kent Beck", 15L, LocalDateTime.parse("2004-11-26T00:00")));
//
//
//
//
//
//        };
//    }

