package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    private String title;
    int count = 0;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract int getPrice();

    public void isSpecial() {
        if (getTitle() == null || getTitle().isEmpty()) {
            System.out.println("Товаров нет");
        }
    }

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