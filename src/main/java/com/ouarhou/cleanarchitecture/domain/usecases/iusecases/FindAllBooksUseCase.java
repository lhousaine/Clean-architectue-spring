package com.ouarhou.cleanarchitecture.domain.usecases.iusecases;

import java.util.Collection;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;

public interface FindAllBooksUseCase {
    public Collection<BookModel> execute();
}
