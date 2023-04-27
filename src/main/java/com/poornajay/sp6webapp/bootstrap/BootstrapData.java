package com.poornajay.sp6webapp.bootstrap;

import com.poornajay.sp6webapp.domain.Author;
import com.poornajay.sp6webapp.domain.Book;
import com.poornajay.sp6webapp.domain.Publisher;
import com.poornajay.sp6webapp.repositories.AuthorRepository;
import com.poornajay.sp6webapp.repositories.BookRepository;
import com.poornajay.sp6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {

        Author poorna = new Author();
        poorna.setFirstName("Poorna");
        poorna.setLastName("Jay");

        Author savedPoorna = authorRepository.save(poorna);

        Author samadhi = new Author();
        samadhi.setFirstName("Samadhi");
        samadhi.setLastName("Jay");

        Author savedSamadhi = authorRepository.save(samadhi);

        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setIsbn("1234");

        Book savedBook1 = bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setIsbn("2345");

        Book savedBook2 = bookRepository.save(book2);

        savedPoorna.getBooks().add(savedBook1);
        savedSamadhi.getBooks().add(savedBook2);

        savedBook1.getAuthors().add(savedPoorna);
        savedBook2.getAuthors().add(savedSamadhi);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Publisher 1");
        publisher1.setAddress("101");
        publisher1.setCity("Melbourne");
        publisher1.setState("VIC");
        publisher1.setZip("3000");

        Publisher savedPublisher1 = publisherRepository.save(publisher1);

        savedBook1.setPublisher(savedPublisher1);
        savedBook2.setPublisher(savedPublisher1);

        authorRepository.save(savedPoorna);
        authorRepository.save(savedSamadhi);

        bookRepository.save(savedBook1);
        bookRepository.save(savedBook2);

        System.out.println("Authors : " + authorRepository.count());
        System.out.println("Books : " + bookRepository.count());
        System.out.println("Publishers : " + publisherRepository.count());

    }
}
