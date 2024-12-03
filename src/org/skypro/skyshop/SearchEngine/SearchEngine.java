package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchable;
    private int size;

    public SearchEngine(int sizeArr) {
        this.searchable = new Searchable[sizeArr];
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
        System.out.println("Результат поиска: " + Arrays.toString(results));
        return results;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < getSearchable().length; i++) {
            if (getSearchable()[i] == null && getSearchable()[i] != searchable) {
                getSearchable()[i] = searchable;
                System.out.println("Товар: (" + searchable.getSearchTerm() + ") добавлен");
                break;
            } else if (getSearchable()[i] != null && getSearchable()[i] == searchable) {
                System.out.println("Данный товар уже добавлен");
                break;
            } else if (i == getSearchable().length - 1) {
                System.out.println("Массив поиска полон");
                break;
            }
        }
    }

}
