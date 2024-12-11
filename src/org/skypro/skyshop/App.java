package org.skypro.skyshop;

import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;

public class App {

    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine();

        // Добавляем товары в ProductBasket
        System.out.println("\nДобавляем товары в ProductBasket:");
        productBasket.acceptSimpleProduct("Груши", 90);
        productBasket.acceptSimpleProduct("Яблоки", 70);
        productBasket.acceptSimpleProduct("Яблоки голден", 110);
        productBasket.acceptDiscountProducts("Бананы", 120, 25);
        productBasket.acceptDiscountProducts("Мандарины", 100, 30);
        productBasket.acceptFixPriceProducts("Финики");
        productBasket.acceptFixPriceProducts("Виноград");
        // Проверка состояния корзины
        System.out.println("\nПроверка состояния корзины:");
        productBasket.printAllContentBasket();

        // Добавляю товары в SearchEngine
        System.out.println("\nДобавляю товары в SearchEngine:");
        searchEngine.add(productBasket.getProduct().get(0));
        searchEngine.add(productBasket.getProduct().get(1));
        searchEngine.add(productBasket.getProduct().get(2));
        searchEngine.add(productBasket.getProduct().get(3));
        searchEngine.add(productBasket.getProduct().get(4));
        searchEngine.add(productBasket.getProduct().get(5));
        searchEngine.add(productBasket.getProduct().get(6));

        // Поиск по товарам
        System.out.println("\nПоиск по товарам:");
        searchEngine.search("Груши");

        // Удалить существующий продукт из корзины
        System.out.println("\nУдалить существующий продукт из корзины:");
        productBasket.removeProduct("Груши");

        // Проверяем что товара (Груши) уже нет
        System.out.println("\nПроверка корзины, что товар удален");
        productBasket.printAllContentBasket();

        // Удаляем не существующий продукт из корзины
        System.out.println("\nУдаляем не существующий продукт из корзины:");
        productBasket.removeProduct("Арбуз");

        // Выводим содержимое корзины
        System.out.println("\nВыводим содержимое корзины");
        productBasket.printAllContentBasket();



    }

}