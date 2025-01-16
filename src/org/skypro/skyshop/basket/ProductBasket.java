package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final TreeMap<String, Product> product;
    private int size;
    private int price;


    public ProductBasket() {
        this.product = new TreeMap<>();
    }

    public TreeMap<String, Product> getProduct() {
        return product;
    }

    public int getCurrentSize() {
        return size;
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductBasket other) {
            if (obj == this) return true;
            if (obj.getClass() != getClass()) return false;
            return product.equals(other.product);
        }
        return false;
    }

    public String toString() {
        return product.toString();
    }

    // Новый метод удаления товаров из корзины
    public void removeProduct(String title) {
        product.entrySet().removeIf(entry -> entry.getKey().equals(title));
    }

    // Метод #1 - принимаем обычные продукты
    public void acceptSimpleProduct(String title, int price) {
        product.put(title, new SimpleProduct(title, price));
        System.out.println("Товар: " + title + " - добавлен в корзину.");
    }

    // Метод #1.2 - принимаем продукты со скидкой
    public void acceptDiscountProducts(String title, int basePrice, int discountPrice) {
        product.put(title, new DiscountedProduct(title, basePrice, discountPrice));
        System.out.println("Товар: " + title + " - добавлен в корзину.");
    }

    // Метод #1.3 - принимаем продукты с фиксированной ценой
    public void acceptFixPriceProducts(String title) {
        product.put(title, new FixPriceProduct(title));
        System.out.println("Товар: " + title + " - добавлен в корзину.");
    }

    // Метод #2 - получения общей стоимости корзины
    public void acceptTotalPrice() {
        int result = product.values().stream()
                .mapToInt(Product::getPrice)
                .sum();
        System.out.println("Общая стоимость корзины: " + result + " рублей.");
    }

    // Метод #3 - печатает содержимое корзины
    public void printAllContentBasket() {
        product.entrySet().forEach(System.out::println);
        int result = product.values().stream()
                .mapToInt(Product::getPrice)
                .sum();
        System.out.println("Итого: " + result + " рублей.");
        int result2 = product.values().stream()
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .toList().size();
        System.out.println("Специальных товаров: " + result2 + " шт.");
    }

    // Метод #4 - проверяем продукт в корзине по имени
    public void checkingProduct(String title) {
        Map<String, List<Product>> result = product.values().stream()
                .filter(product -> product.getTitle().equals(title))
                .collect(Collectors.groupingBy(Product::getTitle));
        System.out.println(result);
    }

    // Метод #5 - очистка корзины
    public void clearBasket() {
        product.clear();
        System.out.println("Корзина очищена");
    }

}