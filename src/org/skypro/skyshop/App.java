package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;

public class App {

    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine();

        // Добавляю Search Engine и надо добавить в него все товары для проверки других методов
        System.out.println("Добавляю все товары");
        searchEngine.add("Яблоки");
        searchEngine.add("Бананы");
        searchEngine.add("Орехи");
        searchEngine.add("Киви");

        // Создаем несколько объектов типа Article и добавляем их в Search Engine
        System.out.println("\nДобавляю статью");
        Article article = new Article("Article Title #1", "Article Description #1");
        System.out.println(article.toString());
        searchEngine.add("Article Title #1, Article Description #1");

        // Продемонстрируем функциональность поиска с помощью объекта SearchEngine
        System.out.println("\nПробуем поискать");
        searchEngine.search("Яблоки");

        //Добавление продукта в корзину
        System.out.println("\nДобавление продукта в корзину");
        productBasket.acceptProducts("Яблоки", 50); // Обычный товар
        productBasket.acceptDiscountProducts("Бананы", 100, 20); // Товар со скидкой
        productBasket.acceptDiscountProducts("Орехи", 150, 30); // Товар со скидкой
        productBasket.acceptFixPriceProducts("Киви"); // Товар со специальной фиксированной ценой
        productBasket.printAllContentBasket();

        //Добавление продукта в заполненную корзину, в которой нет свободного места
        System.out.println("\nДобавление продукта в заполненную корзину, в которой нет свободного места");
        // Сначала заполним корзину
        productBasket.acceptProducts("Помидоры", 80);
        productBasket.acceptProducts("Виноград", 120);
        // Проверим
        productBasket.printAllContentBasket();

        // Попробуем добавить продукт в заполненную корзину
        System.out.println("\nПопробуем добавить продукт в заполненную корзину");
        productBasket.acceptProducts("Баклажаны", 50);

        //Печать содержимого корзины с несколькими товарами
        System.out.println("\nПечать содержимого корзины с несколькими товарами");
        productBasket.printAllContentBasket();

        //Получение стоимости корзины с несколькими товарами
        System.out.println("\nПолучение стоимости корзины с несколькими товарами");
        productBasket.acceptTotalPrice();

        //Поиск товара, который есть в корзине
        System.out.println("\nПоиск товара, который есть в корзине");
        productBasket.checkingProduct("Помидоры");

        //Поиск товара, которого нет в корзине
        System.out.println("\nПоиск товара, которого нет в корзине");
        productBasket.checkingProduct("Вишня");

        //Очистка корзины
        System.out.println("\nОчистка корзины");
        productBasket.clearBasket();

        //Печать содержимого пустой корзины
        System.out.println("\nПечать содержимого пустой корзины");
        productBasket.printAllContentBasket();

        //Получение стоимости пустой корзины
        System.out.println("\nПолучение стоимости пустой корзины");
        productBasket.acceptTotalPrice();

        //Поиск товара по имени в пустой корзине
        System.out.println("\nПоиск товара по имени в пустой корзине");
        productBasket.checkingProduct("Бананы");

    }
}