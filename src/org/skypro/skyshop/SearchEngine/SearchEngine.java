package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> searchable;
    private int size;

    public SearchEngine() {
        this.searchable = new TreeSet<>(new reverseString());
    }

    public int getCurrentSize() {
        return size;
    }

    public Set search(String search) {
        Set<String> objects = new HashSet<>();
        for (Searchable value : searchable) {
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
            if (value.getSearchTerm().toLowerCase().contains(search.toLowerCase())) {
                objects.add(value.getSearchTerm());
            }
        }
        return objects;
    }

    public void add(Searchable goSearchable) {
        searchable.add(goSearchable);
        size++;
        System.out.println(goSearchable.getContentType() + ": " + goSearchable.getSearchTerm() + " - добавлен в SearchEngine");
    }
}
