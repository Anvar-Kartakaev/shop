package org.skypro.skyshop.Article;

import java.util.Arrays;

public interface Searchable {

    default String getStringRepresentation() {
        return getClass().getSimpleName();
    }

    String getSearchTerm();

    String getContentType();

    String getNameTerm();
}
