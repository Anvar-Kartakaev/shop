package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import javax.naming.directory.SearchResult;
import java.util.Arrays;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

//        //Добавление продукта в корзину
//        System.out.println("\nДобавление продукта в корзину");
//        productBasket.acceptProducts("Яблоки", 50); // Обычный товар
//        productBasket.acceptDiscountProducts("Бананы", 100, 20); // Товар со скидкой
//        productBasket.acceptDiscountProducts("Орехи", 150, 30); // Товар со скидкой
//        productBasket.acceptFixPriceProducts("Киви"); // Товар со специальной фиксированной ценой
//        productBasket.printAllContentBasket();
//
//        //Добавление продукта в заполненную корзину, в которой нет свободного места
//        System.out.println("\nДобавление продукта в заполненную корзину, в которой нет свободного места");
//        // Сначала заполним корзину
//        productBasket.acceptProducts("Помидоры", 80);
//        productBasket.acceptProducts("Виноград", 120);
//        // Проверим
//        productBasket.printAllContentBasket();
//
//        // Попробуем добавить продукт в заполненную корзину
//        System.out.println("\nПопробуем добавить продукт в заполненную корзину");
//        productBasket.acceptProducts("Баклажаны", 50);
//
//        //Печать содержимого корзины с несколькими товарами
//        System.out.println("\nПечать содержимого корзины с несколькими товарами");
//        productBasket.printAllContentBasket();
//
//        //Получение стоимости корзины с несколькими товарами
//        System.out.println("\nПолучение стоимости корзины с несколькими товарами");
//        productBasket.acceptTotalPrice();
//
//        //Поиск товара, который есть в корзине
//        System.out.println("\nПоиск товара, который есть в корзине");
//        productBasket.checkingProduct("Помидоры");
//
//        //Поиск товара, которого нет в корзине
//        System.out.println("\nПоиск товара, которого нет в корзине");
//        productBasket.checkingProduct("Вишня");
//
//        //Очистка корзины
//        System.out.println("\nОчистка корзины");
//        productBasket.clearBasket();
//
//        //Печать содержимого пустой корзины
//        System.out.println("\nПечать содержимого пустой корзины");
//        productBasket.printAllContentBasket();
//
//        //Получение стоимости пустой корзины
//        System.out.println("\nПолучение стоимости пустой корзины");
//        productBasket.acceptTotalPrice();
//
//        //Поиск товара по имени в пустой корзине
//        System.out.println("\nПоиск товара по имени в пустой корзине");
//        productBasket.checkingProduct("Бананы");
//
//        //Добавление продуктов в корзину
//        System.out.println("\nДобавление продуктов в корзину");
//        productBasket.acceptProducts("Яблоки", 50); // Обычный товар
//        productBasket.acceptDiscountProducts("Орехи", 150, 30); // Товар со скидкой
//        productBasket.acceptFixPriceProducts("Киви"); // Товар со специальной фиксированной ценой
//        productBasket.printAllContentBasket();
//
//        // Создаем несколько объектов типа Article и добавляем их в Search Engine
//        System.out.println("\nДобавляю статьи");
//        Article article = new Article("Хорошая жизнь", "Вся жизнь человека");
//        Article article2 = new Article("Будни программиста", "Основано на реальных событиях");
//
//        // Добавляю Search Engine и надо добавить в него все товары для проверки других методов
//        System.out.println("\nДобавляю все товары");
//        SearchEngine searchEngine = new SearchEngine(5);
//        searchEngine.add(productBasket.getProduct()[0]);
//        searchEngine.add(productBasket.getProduct()[1]);
//        searchEngine.add(article);
//        //Попробуем добавить одинаковый товар
//        searchEngine.add(productBasket.getProduct()[1]);
//        //Попробуем добавить 6ой товар
//        searchEngine.add(article2);
//
//        System.out.println("\nВывод всех объектов с определением типа:");
//        System.out.println(productBasket.getProduct()[0].getStringRepresentation());
//        System.out.println(productBasket.getProduct()[1].getStringRepresentation());
//        System.out.println(productBasket.getProduct()[2].getStringRepresentation());
//        System.out.println(article.getStringRepresentation());
//        System.out.println(article2.getStringRepresentation());
//
//        System.out.println("\nПробуем что-нибудь найти:");
//        searchEngine.search("Яблоки"); // Должен найти
//        searchEngine.search("Генадий"); // Не должен найти

        // Исключения с ошибками
        SearchEngine searchEngine = new SearchEngine(5);
        System.out.println("\nИсключения:");
        productBasket.acceptProducts("Груши", 90); // Пустое название
        productBasket.acceptProducts("Яблоки", 70); // Нулевая стоимость
        productBasket.acceptProducts("Яблоки Голден", 110); // Нулевая стоимость
        productBasket.acceptDiscountProducts("Бананы", 120, 25); // Некорректная скидка

        // Проверка состояния корзины
        System.out.println("\nПроверка состояния корзины:");
        productBasket.printAllContentBasket();

        // Добавляю товары в SearchEngine
        System.out.println("\nДобавляю товары в SearchEngine:");
        searchEngine.add(productBasket.getProduct()[0]);
        searchEngine.add(productBasket.getProduct()[1]);
        searchEngine.add(productBasket.getProduct()[2]);
        searchEngine.add(productBasket.getProduct()[3]);

        // Поиск по товарам
        System.out.println("\nПоиск по товарам:");
        searchEngine.search("Яблоки");

        // Поиск самого подходящего элемента
        System.out.println("\nПоиск самого подходящего элемента:");
        searchEngine.find("Яблоки");


    }

}