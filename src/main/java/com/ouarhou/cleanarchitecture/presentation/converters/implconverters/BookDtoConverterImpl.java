package com.ouarhou.cleanarchitecture.presentation.converters.implconverters;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;
import com.ouarhou.cleanarchitecture.presentation.converters.iconverters.DtoConverter;
import com.ouarhou.cleanarchitecture.presentation.dto.BookDto;

public class BookDtoConverterImpl implements DtoConverter<BookModel, BookDto> {
    @Override
    public BookModel mapToModel(BookDto bookDto) {
        return new BookModel(bookDto.getId(),bookDto.getTitle(),bookDto.getContent());
    }

    @Override
    public BookDto mapToDto(BookModel bookModel) {
        return new BookDto(bookModel.getId(),bookModel.getTitle(),bookModel.getContent());
    }

}
