package org.skypro.skyshop.product;

import java.util.Objects;

public class FixPriceProduct extends Product {
    public static final int FIX_PRICE = 77;

    public FixPriceProduct(String title){
        super(title);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixPriceProduct product = (FixPriceProduct) o;
        return getTitle().equals(product.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    @Override
    public String toString() {
        return getTitle() + ": Фиксированная цена " + getPrice() + " рублей.";
    }
}
