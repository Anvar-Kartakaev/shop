package org.skypro.skyshop.article;

public class Article {
    private String articleTitle;
    private String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public interface Searchable {
        void searchTerm();
        void contentType();
        default void getStringRepresentation() {
            System.out.println("«имя Searchable-объекта — тип Searchable-объекта»");
        }
    }

    void searchTerm() {
        System.out.println(getArticleTitle() + "\n" + getArticleText());
    }

    void contentType() {
        System.out.println("ARTICLE");
    }

    @Override
    public String toString() {
        return getArticleTitle() + "\n" + getArticleText();
    }
}
