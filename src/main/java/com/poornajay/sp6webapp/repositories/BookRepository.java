package com.poornajay.sp6webapp.repositories;

import com.poornajay.sp6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
