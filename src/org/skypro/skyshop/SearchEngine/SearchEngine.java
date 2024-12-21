package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SearchEngine {
    private final ArrayList<Searchable> searchable;
    private int size;

    public SearchEngine() {
        this.searchable = new ArrayList<>();
    }

    public int getCurrentSize() {
        return size;
    }

    public void search(String search) {
        searchingMethod(search);
    }

    public void add(Searchable goSearchable) {
        searchable.add(goSearchable);
        size++;
        System.out.println("Товар: " + goSearchable.getSearchTerm() + " - добавлен в SearchEngine");
    }

    public void searchingMethod(String search) {
        for (int i = 0; i < searchable.size(); i++) {
            if (search == null) {
                throw new NullPointerException("Поисковая строка не может быть Null");
            }
            if (search.isEmpty()) {
                System.out.println("Вы ввели пустой поисковый запрос");
                break;
            }
            if (search.isBlank()) {
                System.out.println("Запрос не может состоять только из пробелов");
                break;
            }
            if (search != null && searchable.get(i) != null && searchable.get(i).getSearchTerm().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(searchable.get(i));
            }
        }
    }

}
