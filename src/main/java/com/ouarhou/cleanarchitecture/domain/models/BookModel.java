package com.ouarhou.cleanarchitecture.domain.models;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ouarhou.cleanarchitecture.core.validation.SelfValidating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel extends SelfValidating<BookModel> implements Serializable {
    @NotNull
    @Min(0)
    private Integer id;
    @Size(min = 10, max = 100, message = "Number of characters should be in between 10 and 100 inclusive")
    private String title;
    @Size(min = 10, max = 2000, message = "Number of characters should be in between 10 and 2000 inclusive")
    private String content;
}
