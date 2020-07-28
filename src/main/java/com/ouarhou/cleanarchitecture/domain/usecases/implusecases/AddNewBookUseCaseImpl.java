package com.ouarhou.cleanarchitecture.domain.usecases.implusecases;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;
import com.ouarhou.cleanarchitecture.domain.repositoryservices.BookRepositoryService;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.AddNewBookUseCase;

public class AddNewBookUseCaseImpl implements AddNewBookUseCase {
    private final BookRepositoryService bookRepositoryService;

    public AddNewBookUseCaseImpl(BookRepositoryService bookRepositoryService) {

        this.bookRepositoryService = bookRepositoryService;
    }

    @Override
    public BookModel execute(BookModel book) {
        return bookRepositoryService.addNewBook(book);
    }
}
