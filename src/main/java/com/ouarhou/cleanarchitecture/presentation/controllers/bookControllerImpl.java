package com.ouarhou.cleanarchitecture.presentation.controllers;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ouarhou.cleanarchitecture.domain.models.BookModel;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.AddNewBookUseCase;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.DeleteBookUseCase;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.FindAllBooksUseCase;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.FindBookByIdUseCase;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.UpdateBookUseCase;
import com.ouarhou.cleanarchitecture.presentation.converters.iconverters.DtoConverter;
import com.ouarhou.cleanarchitecture.presentation.dto.BookDto;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class bookControllerImpl implements BookController {
    private final FindAllBooksUseCase findAllBooksUseCase;
    private final FindBookByIdUseCase findBookByIdUseCase;
    private final AddNewBookUseCase addNewBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DtoConverter<BookModel,BookDto> bookDtoConverter;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<BookDto> findAllBooks() {
        return findAllBooksUseCase.execute().stream().map(bookDtoConverter::mapToDto)
            .collect(Collectors.toList());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{bookId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto findBookById(@PathVariable("bookId") int bookId) {
        return bookDtoConverter.mapToDto(findBookByIdUseCase.execute(bookId));
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto addNewBook(@RequestBody BookDto book) {
        return bookDtoConverter.mapToDto(addNewBookUseCase.execute(bookDtoConverter.mapToModel(book)));
    }

    @Override
    @DeleteMapping(value = "/{bookId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
        deleteBookUseCase.execute(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PatchMapping(value = "/{bookId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto updateBook(@PathVariable("bookId") int bookId,@RequestBody BookDto book) throws NotFoundException {
        return bookDtoConverter.mapToDto(updateBookUseCase.execute(bookId,bookDtoConverter.mapToModel(book)));
    }
}
