package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercentage;

    public DiscountedProduct(String title, int basePrice, int discountPercentage) {
        super(title);
        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public int getPrice() {
        return ((100 - discountPercentage) * basePrice) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountedProduct product = (DiscountedProduct) o;
        return basePrice == product.basePrice && discountPercentage == product.discountPercentage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basePrice, discountPercentage);
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice() + " рублей." + " Скидка (" + getDiscountPercentage() + "%)";
    }
}