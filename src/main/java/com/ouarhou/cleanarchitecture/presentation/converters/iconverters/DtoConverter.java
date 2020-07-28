package com.ouarhou.cleanarchitecture.presentation.converters.iconverters;

import java.io.Serializable;

public interface DtoConverter<M extends Serializable, D extends Serializable> {

    default M mapToModel(final D bookDto) {
        throw new UnsupportedOperationException();
    }

    default D mapToDto(final M bookModel) {
        throw new UnsupportedOperationException();
    }
}
