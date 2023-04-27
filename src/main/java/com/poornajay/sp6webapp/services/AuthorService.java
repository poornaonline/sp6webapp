package com.poornajay.sp6webapp.services;

import com.poornajay.sp6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
