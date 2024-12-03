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
        return "\n" + getArticleTitle() + "\n" + getArticleDescription();
    }

    @Override
    public String getSearchTerm() {
        return getArticleTitle();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getNameTerm() {
        return getArticleTitle();
    }
}