package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

public class SearchEngine {
    private final Searchable[] searchable;
    private int size;

    public SearchEngine(Searchable[] searchable) {
        this.searchable = new Searchable[5];
    }

    public Searchable[] getSearchable() {
        return searchable;
    }

    public int getCurrentSize() {
        return size;
    }

    String search(String query) {
        for (Searchable value : searchable) {
            if (value != null && value.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(value);
            }
        }
        return query;
    }

    public void add(String keyword) {
        if (size >= searchable.length) {
            System.out.println("Массив поиска полон");
        } else {
            Searchable list = searchable[size];
            searchable[size++] = list;
        }
    }

}
