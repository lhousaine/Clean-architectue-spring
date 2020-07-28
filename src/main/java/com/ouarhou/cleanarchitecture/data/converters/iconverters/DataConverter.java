package com.ouarhou.cleanarchitecture.data.converters.iconverters;
import java.io.Serializable;

public interface DataConverter<E extends Serializable, M extends Serializable> {

    default E mapToEntity(final M bookModel) {
        throw new UnsupportedOperationException();
    }

    default M mapToModel(final E bookEntity) {
        throw new UnsupportedOperationException();
    }

}