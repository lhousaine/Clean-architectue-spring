package com.ouarhou.cleanarchitecture.core.configuration;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ouarhou.cleanarchitecture.data.converters.iconverters.DataConverter;
import com.ouarhou.cleanarchitecture.data.converters.impl_converters.BookDataConverter;
import com.ouarhou.cleanarchitecture.data.entities.BookEntity;
import com.ouarhou.cleanarchitecture.data.repositories.BookRepository;
import com.ouarhou.cleanarchitecture.data.repositoryservicesimpl.BookRepositoryServiceImpl;
import com.ouarhou.cleanarchitecture.domain.models.BookModel;
import com.ouarhou.cleanarchitecture.domain.repositoryservices.BookRepositoryService;
import com.ouarhou.cleanarchitecture.domain.usecases.implusecases.AddNewBookUseCaseImpl;
import com.ouarhou.cleanarchitecture.domain.usecases.implusecases.DeleteBookUseCaseImpl;
import com.ouarhou.cleanarchitecture.domain.usecases.implusecases.FindAllBooksUseCaseImpl;
import com.ouarhou.cleanarchitecture.domain.usecases.implusecases.FindBookByIdUseCaseImpl;
import com.ouarhou.cleanarchitecture.domain.usecases.implusecases.UpdateBookUseCaseImpl;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.AddNewBookUseCase;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.DeleteBookUseCase;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.FindAllBooksUseCase;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.FindBookByIdUseCase;
import com.ouarhou.cleanarchitecture.domain.usecases.iusecases.UpdateBookUseCase;
import com.ouarhou.cleanarchitecture.presentation.converters.iconverters.DtoConverter;
import com.ouarhou.cleanarchitecture.presentation.converters.implconverters.BookDtoConverterImpl;
import com.ouarhou.cleanarchitecture.presentation.dto.BookDto;

@Configuration
public class BeansConfig {
    @Inject
    private BookRepository bookRepository;

    @Bean
    public DtoConverter<BookModel, BookDto> createDtoConverter() {
        return new BookDtoConverterImpl();
    }

    @Bean
    public DataConverter<BookEntity, BookModel> createDataConverter() {
        return new BookDataConverter();
    }

    @Bean
    public BookRepositoryService createBookRepositoryService() {
        return new BookRepositoryServiceImpl(bookRepository,createDataConverter());
    }

    @Bean
    public FindAllBooksUseCase createCreateCategoryUseCase() {
        return new FindAllBooksUseCaseImpl(createBookRepositoryService());
    }

    @Bean
    public FindBookByIdUseCase FindBookByIdUseCase() {
        return new FindBookByIdUseCaseImpl(createBookRepositoryService());
    }

    @Bean
    public AddNewBookUseCase createAddNewBookUseCase() {
        return new AddNewBookUseCaseImpl(createBookRepositoryService());
    }
    @Bean
    public UpdateBookUseCase createUpdateBookUseCase() {
        return new UpdateBookUseCaseImpl(createBookRepositoryService());
    }

    @Bean
    public DeleteBookUseCase createDeleteBookUseCase() {
        return new DeleteBookUseCaseImpl(createBookRepositoryService());
    }

}
