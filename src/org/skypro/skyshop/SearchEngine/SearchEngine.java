package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchable;
    private int size;

    public SearchEngine(int sizeArr) {
        this.searchable = new Searchable[sizeArr];
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

    public void add(Searchable goSearchable) {
        for (int i = 0; i < searchable.length; i++) {
            if (searchable[i] == null && searchable[i] != goSearchable) {
                searchable[i] = goSearchable;
                System.out.println("Товар: (" + goSearchable.getSearchTerm() + ") добавлен");
                break;
            } else if (searchable[i] != null && searchable[i] == goSearchable) {
                System.out.println("Данный товар уже добавлен");
                break;
            } else if (i == searchable.length - 1) {
                System.out.println("Массив поиска полон");
                break;
            }
        }
    }

    public void find(String search) {
        BestResultNotFound(search);
    }

    public void BestResultNotFound(String search) {
        for (int i = 0; i < searchable.length; i++) {
            if (search.isEmpty()) {
                System.out.println("Вы ввели пустой поисковый запрос");
                break;
            }
            if (search.isBlank()) {
                System.out.println("Запрос не может состоять только из пробелов");
                break;
            }
            if (search != null && searchable[i] != null && searchable[i].getSearchTerm().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(searchable[i].getSearchTerm());
            }
        }
    }

}

