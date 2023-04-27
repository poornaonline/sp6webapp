package com.poornajay.sp6webapp.services;

import com.poornajay.sp6webapp.domain.Book;

public interface BookingService {

    Iterable<Book> findAll();
}
