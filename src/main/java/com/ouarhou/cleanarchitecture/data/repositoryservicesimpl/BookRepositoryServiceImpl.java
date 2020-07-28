package com.ouarhou.cleanarchitecture.data.repositoryservicesimpl;

import java.util.Collection;
import java.util.stream.Collectors;

import com.ouarhou.cleanarchitecture.data.converters.iconverters.DataConverter;
import com.ouarhou.cleanarchitecture.data.entities.BookEntity;
import com.ouarhou.cleanarchitecture.data.repositories.BookRepository;
import com.ouarhou.cleanarchitecture.domain.models.BookModel;
import com.ouarhou.cleanarchitecture.domain.repositoryservices.BookRepositoryService;

import javassist.NotFoundException;

public class BookRepositoryServiceImpl implements BookRepositoryService {
    private final BookRepository bookRepository;
    private final DataConverter<BookEntity, BookModel> dataConverter;

    public BookRepositoryServiceImpl(BookRepository bookRepository, DataConverter<BookEntity, BookModel> dataConverter) {
        this.bookRepository = bookRepository;
        this.dataConverter = dataConverter;
    }

    @Override
    public Collection<BookModel> findAllBooks() {
        return bookRepository.findAll()
            .stream()
            .map(dataConverter::mapToModel)
            .collect(Collectors.toList());
    }

    @Override
    public BookModel findBookById(int bookId) {
        return bookRepository.findById(bookId)
            .map(dataConverter::mapToModel)
            .get();
    }

    @Override
    public BookModel addNewBook(BookModel book) {
        return dataConverter.mapToModel(bookRepository.save(dataConverter.mapToEntity(book)));
    }

    @Override
    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookModel updateBook(int bookId, BookModel book) throws NotFoundException {
        if (!bookRepository.findById(bookId).isPresent()) {
            throw new NotFoundException("No book was identified by " + bookId);
        }
        book.setId(bookId);
        return dataConverter.mapToModel(bookRepository.save(dataConverter.mapToEntity(book)));
    }
}
