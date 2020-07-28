package com.ouarhou.cleanarchitecture.domain.usecases.implusecases;

import java.util.Collection;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;
import com.ouarhou.cleanarchitecture.domain.repositoryservices.BookRepositoryService;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.FindAllBooksUseCase;

public class FindAllBooksUseCaseImpl implements FindAllBooksUseCase {
    private final BookRepositoryService bookRepositoryService;

    public FindAllBooksUseCaseImpl(BookRepositoryService bookRepositoryService) {
        this.bookRepositoryService = bookRepositoryService;
    }

    @Override
    public Collection<BookModel> execute() {
        return bookRepositoryService.findAllBooks();
    }
}
