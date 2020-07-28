package com.ouarhou.cleanarchitecture.domain.usecases.implusecases;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;
import com.ouarhou.cleanarchitecture.domain.repositoryservices.BookRepositoryService;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.FindBookByIdUseCase;

public class FindBookByIdUseCaseImpl implements FindBookByIdUseCase {
    private final BookRepositoryService bookRepositoryService;

    public FindBookByIdUseCaseImpl(BookRepositoryService bookRepositoryService) {
        this.bookRepositoryService = bookRepositoryService;
    }

    @Override
    public BookModel execute(int bookId) {
        return bookRepositoryService.findBookById(bookId);
    }
}
