package com.poornajay.sp6webapp.repositories;

import com.poornajay.sp6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
