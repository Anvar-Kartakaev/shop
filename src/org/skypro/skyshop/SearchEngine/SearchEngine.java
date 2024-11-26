package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.Article.Searchable;

public class SearchEngine {
    private final Searchable[] searchable;
    private int size;

    public SearchEngine() {
        this.searchable = new Searchable[5];
    }

    public Searchable[] getSearchable() {
        return searchable;
    }

    public int getCurrentSize() {
        return size;
    }

    public void search(String query) {
        for (Searchable value : searchable) {
            if (value != null) {
                System.out.println(value);
            }
        }
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
