package org.skypro.skyshop;

import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;

public class App {

    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine();

        // Добавляем товары в ProductBasket
        System.out.println("\nДобавляем товары в ProductBasket");
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
        searchEngine.add(productBasket.getProduct().get("Груши"));
        searchEngine.add(productBasket.getProduct().get("Яблоки"));
        searchEngine.add(productBasket.getProduct().get("Яблоки голден"));
        searchEngine.add(productBasket.getProduct().get("Бананы"));
        searchEngine.add(productBasket.getProduct().get("Мандарины"));
        searchEngine.add(productBasket.getProduct().get("Финики"));
        searchEngine.add(productBasket.getProduct().get("Виноград"));

        // Поиск по товарам
        System.out.println("\nПоиск по товарам:");
        searchEngine.search("Яблоки");

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