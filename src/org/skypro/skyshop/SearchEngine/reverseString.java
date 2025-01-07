package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

import java.util.Comparator;

public class reverseString implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        Integer one = Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length());
        if (one == 0) {
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        }
        return o1.getSearchTerm().compareTo(o2.getSearchTerm());
    }
}
