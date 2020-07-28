package com.ouarhou.cleanarchitecture.domain.usecases.iusecases;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;

public interface AddNewBookUseCase {
    public BookModel execute(BookModel book);
}
