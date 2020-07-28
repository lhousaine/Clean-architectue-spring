package com.ouarhou.cleanarchitecture.presentation.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.ouarhou.cleanarchitecture.presentation.dto.BookDto;

import javassist.NotFoundException;

public interface BookController {
    public Collection<BookDto> findAllBooks();
    public BookDto findBookById(int bookId);
    public BookDto addNewBook(BookDto book);
    public ResponseEntity<Void> deleteBook(int bookId);
    public BookDto updateBook(int bookId, BookDto book) throws NotFoundException;
}
