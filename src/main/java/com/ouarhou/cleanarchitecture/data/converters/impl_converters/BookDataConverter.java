package com.ouarhou.cleanarchitecture.data.converters.impl_converters;

import com.ouarhou.cleanarchitecture.data.converters.iconverters.DataConverter;
import com.ouarhou.cleanarchitecture.data.entities.BookEntity;
import com.ouarhou.cleanarchitecture.domain.models.BookModel;

public class BookDataConverter implements DataConverter<BookEntity, BookModel> {
    @Override
    public BookEntity mapToEntity(BookModel bookModel) {
        return new BookEntity(bookModel.getId(),bookModel.getTitle(),bookModel.getContent());
    }

    @Override
    public BookModel mapToModel(BookEntity bookEntity) {
        return new BookModel(bookEntity.getId(),bookEntity.getTitle(),bookEntity.getContent());
    }
}
