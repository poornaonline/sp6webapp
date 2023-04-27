package com.poornajay.sp6webapp.services;

import com.poornajay.sp6webapp.domain.Book;
import com.poornajay.sp6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookRepository bookRepository;

    public BookingServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
