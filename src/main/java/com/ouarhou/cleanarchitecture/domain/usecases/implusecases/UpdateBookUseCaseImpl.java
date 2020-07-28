package com.ouarhou.cleanarchitecture.domain.usecases.implusecases;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;
import com.ouarhou.cleanarchitecture.domain.repositoryservices.BookRepositoryService;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.UpdateBookUseCase;

import javassist.NotFoundException;

public class UpdateBookUseCaseImpl implements UpdateBookUseCase {
    private final BookRepositoryService bookRepositoryService;

    public UpdateBookUseCaseImpl(BookRepositoryService bookRepositoryService) {
        this.bookRepositoryService = bookRepositoryService;
    }

    @Override
    public BookModel execute(int bookId, BookModel book) throws NotFoundException {
        return bookRepositoryService.updateBook(bookId,book);
    }
}
