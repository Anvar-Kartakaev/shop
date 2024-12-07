package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String title, int price) {
        super(title);
        this.price = price;
        try {
            checkPrice(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Указана некорректная стоимость для товара: " + price);
        }
    }

    public static void checkPrice(int price) throws IllegalArgumentException {
        if (price <= 0) throw new IllegalArgumentException();
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleProduct product = (SimpleProduct) o;
        return price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice() + " рублей.";
    }
}