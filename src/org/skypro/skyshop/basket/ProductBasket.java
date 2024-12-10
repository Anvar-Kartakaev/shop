package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ProductBasket {
    private final ArrayList<Product> product;
    private int size;


    public ProductBasket() {
        this.product = new ArrayList<>();
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public int getCurrentSize() {
        return size;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getProduct().toArray());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductBasket other) {
            if (obj == this) return true;
            if (obj.getClass() != getClass()) return false;
            return java.util.Arrays.equals(getProduct().toArray(), other.getProduct().toArray());
        }
        return false;
    }

    public String toString() {
        return Arrays.toString(getProduct().toArray());
    }

    // Новый метод удаления товаров из корзины
    public void removeProduct(String title) {
        Iterator<Product> name = product.iterator();
        while (name.hasNext()) {
            Product product = name.next();
            if (product.getTitle().equals(title)) {
                System.out.println("Удаление товара: (" + product.getTitle() + ") - завершено.");
                name.remove();
                size--;
                break;
            } else {
                System.out.println("Товар: (" + title + ") - не существует.");
                break;
            }
        }
    }

    // Метод #1 - принимаем обычные продукты
    public void acceptSimpleProduct(String title, int price) {
        product.add(new SimpleProduct(title, price));
    }

    // Метод #1.2 - принимаем продукты со скидкой
    public void acceptDiscountProducts(String title, int basePrice, int discountPrice) {
        product.add(new DiscountedProduct(title, basePrice, discountPrice));
    }

    // Метод #1.3 - принимаем продукты с фиксированной ценой
    public void acceptFixPriceProducts(String title) {
        product.add(new FixPriceProduct(title));
    }

    // Метод #2 - получения общей стоимости корзины
    public void acceptTotalPrice() {
        int sum = 0;
        for (int i = 0; i < product.size(); i++) {
            sum += product.get(i).getPrice();
        }
        System.out.println("Общая стоимость корзины: " + sum + " рублей.");
    }

    // Метод #3 - печатает содержимое корзины
    public void printAllContentBasket() {
        int sum = 0;
        int isSpecial = 0;
        for (int i = 0; i < product.size(); i++) {
            if (size <= product.size()) {
                System.out.println(product.get(i).toString());
                sum += product.get(i).getPrice();
                if (product.get(i).isSpecial() == true) {
                    isSpecial++;
                }
            }
        }
        System.out.println("Итого: " + sum + " рублей.\nСпециальных товаров: " + isSpecial + " шт.");
        if (product.size() <= 0) {
            System.out.println("В корзине пусто");
        }
    }

    // Метод #4 - проверяем продукт в корзине по имени
    public void checkingProduct(String title) {
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getTitle().equals(title)) {
                System.out.println("Продукт: " + product.get(i).getTitle() + " - есть в корзине");
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