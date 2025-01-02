package org.skypro.skyshop.Article;

import java.util.Comparator;

public interface Searchable {

    default String getStringRepresentation() {
        return "Объект " + getContentType() + " типа " + getNameTerm();
    }

    String getSearchTerm();

    String getContentType();

    String getNameTerm();
}