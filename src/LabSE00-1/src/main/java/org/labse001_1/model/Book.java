package org.labse001_1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String ISBN;
    private String title;
    private int year;
    private Author author;
    private String type;

}
