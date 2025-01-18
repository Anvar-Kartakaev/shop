package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchable;
    private int size;

    public SearchEngine() {
        this.searchable = new TreeSet<>(new reverseString());
    }

    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SearchEngine) {
            return searchable.equals(((SearchEngine)obj).searchable);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return searchable.hashCode();
    }

    @Override
    public String toString() {
        return searchable.toString();
    }

    public Set<Searchable> search(String search) {
        List<Searchable> result = searchable.stream()
                .filter(Objects::nonNull)
                .filter(searchable -> searchable.toString().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result);
        return new HashSet<>(result);
    }

    public void add(Searchable goSearchable) {
        searchable.add(goSearchable);
        size++;
        System.out.println(goSearchable.getContentType() + ": " + goSearchable.getSearchTerm() + " - добавлен в SearchEngine");
    }
}
