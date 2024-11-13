package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] product;
    private int size;

    public ProductBasket() {
        this.product = new Product[5];
    }

    public Product[] getProduct() {
        return product;
    }

    public int getCurrentSize() {
        return size;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(product);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductBasket other) {
            if (obj == this) return true;
            if (obj.getClass() != getClass()) return false;
            return java.util.Arrays.equals(getProduct(), other.getProduct());
        }
        return false;
    }

    public String toString() {
        return Arrays.toString(product);
    }

    // Метод #1 - принимаем продукты
    public void acceptProducts(String title, int price) {
        if (size >= product.length) {
            System.out.println("Невозможно добавить продукт");
        } else {
            Product cartList = new Product(title, price);
            product[size++] = cartList;
        }
    }

    // Метод #2 - получения общей стоимости корзины
    public void acceptTotalPrice() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += product[i].getPrice();
        }
        System.out.println("Общая стоимость корзины: " + sum + " рублей.");
    }

    // Метод #3 - печатает содержимое корзины
    public void printAllContentBasket() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (size <= product.length) {
                System.out.println(product[i].toString());
                sum += product[i].getPrice();
            }
        }
        System.out.println("Итого: " + sum + " рублей.");
        if (size <= 0) {
            System.out.println("В корзине пусто");
        }
    }

    // Метод #4 - проверяем продукт в корзине по имени
    public void checkingProduct(String title) {
        for (int i = 0; i < size; i++) {
            if (product[i].getTitle().equals(title)) {
                System.out.println("Продукт: " + product[i].getTitle() + " - есть в корзине");
                return;
            }
        }
        System.out.println("Продукта: " + title + " - нет в корзине");
    }

    // Метод #5 - очистка корзины
    public void clearBasket() {
        for (int i = 0; i < product.length; i++) {
            product[i] = null;
            size = 0;
        }
        System.out.println("Корзина очищена");
    }

}
