package com.ouarhou.cleanarchitecture.domain.usecases.iusecases;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;

public interface FindBookByIdUseCase {
    public BookModel execute(int bookId);
}
