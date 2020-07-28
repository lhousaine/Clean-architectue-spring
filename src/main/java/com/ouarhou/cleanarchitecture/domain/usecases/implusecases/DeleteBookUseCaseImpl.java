package com.ouarhou.cleanarchitecture.domain.usecases.implusecases;

import com.ouarhou.cleanarchitecture.domain.repositoryservices.BookRepositoryService;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.DeleteBookUseCase;

public class DeleteBookUseCaseImpl implements DeleteBookUseCase {
    private final BookRepositoryService bookRepositoryService;

    public DeleteBookUseCaseImpl(BookRepositoryService bookRepositoryService) {
        this.bookRepositoryService = bookRepositoryService;
    }

    @Override
    public void execute(int bookId) {
         bookRepositoryService.deleteBook(bookId);
    }
}
