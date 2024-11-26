package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Article;

import java.util.Objects;

public abstract class Product implements Article.Searchable {
    private String title;

    public Product(String title) {
        this.title = title;
    }

    public void searchTerm() {
        System.out.println(getTitle());
    }

    public void contentType() {
        System.out.println("PRODUCT");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSpecial() {
        return false;
    }

    public abstract int getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return getTitle();
    }
}