package org.skypro.skyshop.Article;

import java.util.Arrays;

public interface Searchable {

    default String getStringRepresentation() {
        return "Объект " + getContentType() + " типа " + getNameTerm();
    }

    String getSearchTerm();

    String getContentType();

    String getNameTerm();
}
