package com.ouarhou.cleanarchitecture.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ouarhou.cleanarchitecture.data.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

}
