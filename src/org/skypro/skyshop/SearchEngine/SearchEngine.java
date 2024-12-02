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

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int counter = 0;
        for (Searchable value : searchable) {
            if (value != null && value.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[counter++] = value;
                if (counter >= searchable.length) {
                    break;
                }
            }
        }
        return results;
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
