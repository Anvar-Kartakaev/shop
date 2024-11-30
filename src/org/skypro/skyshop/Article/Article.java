package org.skypro.skyshop.Article;

public class Article implements Searchable {
    private final String articleTitle;
    private final String articleDescription;

    public Article(String articleTitle, String articleDescription) {
        this.articleTitle = articleTitle;
        this.articleDescription = articleDescription;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public String toString() {
        return getArticleTitle() + "\n" + getArticleDescription();
    }

    @Override
    public String searchTerm() {
        return getArticleTitle() + "\n" + getArticleDescription();
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }

    @Override
    public String nameTerm() {
        return "ЧТО ТУТ ДОЛЖНО БЫТЬ?";
    }
}