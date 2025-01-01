package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.TreeMap;

public class ProductBasket {
    private final TreeMap<String, Product> product;
    private int size;


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
        for (Product p : product.values()) {
            if (p.getTitle().equals(title)) {
                product.remove(p.getTitle());
                size--;
                System.out.println("Товар: " + p.getTitle() + " - удален.");
                break;
            }
        }
    }

    // Метод #1 - принимаем обычные продукты
    public void acceptSimpleProduct(String title, int price) {
        product.put(title, new SimpleProduct(title, price));
    }

    // Метод #1.2 - принимаем продукты со скидкой
    public void acceptDiscountProducts(String title, int basePrice, int discountPrice) {
        product.put(title, new DiscountedProduct(title, basePrice, discountPrice));
    }

    // Метод #1.3 - принимаем продукты с фиксированной ценой
    public void acceptFixPriceProducts(String title) {
        product.put(title, new FixPriceProduct(title));
    }

    // Метод #2 - получения общей стоимости корзины
    public void acceptTotalPrice() {
        int sum = 0;
        for (Product p : product.values()) {
            sum += product.get(p.getTitle()).getPrice();
        }
        System.out.println("Общая стоимость корзины: " + sum + " рублей.");
    }

    // Метод #3 - печатает содержимое корзины
    public void printAllContentBasket() {
        int sum = 0;
        int isSpecial = 0;
        for (Product product : product.values()) {
            System.out.println(product.toString());
            sum += product.getPrice();
            if (product.isSpecial()) {
                isSpecial++;
            }
        }
        System.out.println("Итого: " + sum + " рублей.\nСпециальных товаров: " + isSpecial + " шт.");
        if (product.size() <= 0) {
            System.out.println("В корзине пусто");
        }
    }

    // Метод #4 - проверяем продукт в корзине по имени
    public void checkingProduct(String title) {
        for (Product p : product.values()) {
            if (product.get(p.getTitle()).getTitle().equals(title)) {
                System.out.println("Продукт: " + product.get(p.getTitle()) + " - есть в корзине");
                return;
            }
        }
        System.out.println("Продукта: " + title + " - нет в корзине");
    }

    // Метод #5 - очистка корзины
    public void clearBasket() {
        product.clear();
        System.out.println("Корзина очищена");
    }

}