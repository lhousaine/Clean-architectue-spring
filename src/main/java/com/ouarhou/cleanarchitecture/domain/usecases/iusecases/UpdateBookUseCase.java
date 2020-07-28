package com.ouarhou.cleanarchitecture.domain.usecases.iusecases;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;

import javassist.NotFoundException;

public interface UpdateBookUseCase {
    public BookModel execute(int bookId, BookModel book) throws NotFoundException;
}
