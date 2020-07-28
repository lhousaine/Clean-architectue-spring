package com.ouarhou.cleanarchitecture.domain.repositoryservices;

import java.util.Collection;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;

import javassist.NotFoundException;

public interface BookRepositoryService {
    public Collection<BookModel> findAllBooks();
    public BookModel findBookById(int bookId);
    public BookModel addNewBook(BookModel book);
    public void deleteBook(int bookId);
    public BookModel updateBook(int bookId, BookModel book) throws NotFoundException;
}
