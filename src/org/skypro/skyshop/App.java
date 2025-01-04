package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
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
        productBasket.acceptSimpleProduct("Клубника", 110);
        productBasket.acceptSimpleProduct("Апельсины", 110);
        productBasket.acceptSimpleProduct("Бананы-мини", 80);
        productBasket.acceptSimpleProduct("Бананы-средние", 95);
        productBasket.acceptSimpleProduct("Вишня", 95);
        productBasket.acceptSimpleProduct("Сливы", 145);
        productBasket.acceptDiscountProducts("Лайм", 120, 25);
        productBasket.acceptDiscountProducts("Манго", 130, 15);
        productBasket.acceptDiscountProducts("Гранат-азербайджанский", 130, 5);
        productBasket.acceptDiscountProducts("Мандарины", 100, 30);
        productBasket.acceptDiscountProducts("Орехи", 80, 5);
        productBasket.acceptFixPriceProducts("Финики");
        productBasket.acceptFixPriceProducts("Гранат-восток");
        productBasket.acceptFixPriceProducts("Виноград");
        // Проверка состояния корзины
        System.out.println("\nПроверка состояния корзины:");
        productBasket.printAllContentBasket();

        // Добавляю статьи
        Article article1 = new Article("Word", "All word the our planet");
        Article article2 = new Article("World the line", "The my world before line");
        Article article3 = new Article("End the World limit", "The my world witch limited");
        Article article4 = new Article("My Life", "Is cool story");
        Article article5 = new Article("New planets", "All planet in our solar system");
        Article article6 = new Article("My family", "Wife, son, my home and work");
        Article article7 = new Article("All country", "Russia this is really big country");
        Article article8 = new Article("My term by dev", "My term for development in Java");

        // Добавляю товары в SearchEngine
        System.out.println("\nДобавляю товары в SearchEngine:");
        searchEngine.add(productBasket.getProduct().get("Груши"));
        searchEngine.add(productBasket.getProduct().get("Яблоки"));
        searchEngine.add(productBasket.getProduct().get("Клубника"));
        searchEngine.add(productBasket.getProduct().get("Апельсины"));
        searchEngine.add(productBasket.getProduct().get("Бананы-мини"));
        searchEngine.add(productBasket.getProduct().get("Бананы-средние"));
        searchEngine.add(productBasket.getProduct().get("Вишня"));
        searchEngine.add(productBasket.getProduct().get("Сливы"));
        searchEngine.add(productBasket.getProduct().get("Лайм"));
        searchEngine.add(productBasket.getProduct().get("Манго"));
        searchEngine.add(productBasket.getProduct().get("Гранат-азербайджанский"));
        searchEngine.add(productBasket.getProduct().get("Мандарины"));
        searchEngine.add(productBasket.getProduct().get("Орехи"));
        searchEngine.add(productBasket.getProduct().get("Финики"));
        searchEngine.add(productBasket.getProduct().get("Гранат-восток"));
        searchEngine.add(productBasket.getProduct().get("Виноград"));
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);
        searchEngine.add(article6);
        searchEngine.add(article7);
        searchEngine.add(article8);

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

        // Поиск по товарам
        System.out.println("\nПоиск по товарам:");
        searchEngine.search("World");


    }

}