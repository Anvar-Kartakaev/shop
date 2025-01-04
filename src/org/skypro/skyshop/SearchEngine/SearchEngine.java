package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> searchable;
    private int size;

    public SearchEngine() {
        this.searchable = new TreeSet<>(new reverseString());
    }

    public static class reverseString implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            Integer one = Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length());
            if (one == 0) {
                return o1.getSearchTerm().compareTo(o2.getSearchTerm());
            }
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        }
    }

    public int getCurrentSize() {
        return size;
    }

    public void search(String search) {
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
                System.out.println(value.getSearchTerm());
            }
        }
    }

    public void add(Searchable goSearchable) {
        searchable.add(goSearchable);
        size++;
        System.out.println(goSearchable.getContentType() + ": " + goSearchable.getSearchTerm() + " - добавлен в SearchEngine");
    }
}
