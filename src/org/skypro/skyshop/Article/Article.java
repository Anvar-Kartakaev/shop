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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Article) {
            Article other = (Article) obj;
            return articleTitle.equals(other.articleTitle);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return articleTitle.hashCode();
    }

    public String toString() {
        return "\n" + getArticleTitle() + " - " + getArticleDescription();
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