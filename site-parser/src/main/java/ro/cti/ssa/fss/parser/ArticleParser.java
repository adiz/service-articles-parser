package ro.cti.ssa.fss.parser;

import org.jsoup.nodes.Document;
import ro.cti.ssa.fss.document.Article;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 3/22/2014
 */
public abstract class ArticleParser {

    Document document;

    public ArticleParser(Document document){
        this.document = document;
    }

    public abstract String getTitle();

    public abstract List<String> getAuthors();

    public abstract String getArticleAbstract();

    public abstract List<String> getKeywords();

    public abstract String getPublication();

    public abstract String getPublicationDate();

    public abstract String getPublisher();

    public abstract List<String> getEditors();

    public abstract List<String> getOrganizations();

    public abstract String getEvent();

    public abstract String getDownloadLink();

    public String getDetails(){
        return document.baseUri();
    }

    public Article createArticle(){

        Article article = new Article();

        article.setTitle(getTitle());
        article.setAuthors(getAuthors());
        article.setArticleAbstract(getArticleAbstract());
        article.setKeywords(getKeywords());
        article.setPublication(getPublication());
        article.setPublicationDate(getPublicationDate());
        article.setPublisher(getPublisher());
        article.setEditors(getEditors());
        article.setOrganizations(getOrganizations());
        article.setEvent(getEvent());
        article.setDownloadLink(getDownloadLink());
        article.setDetails(getDetails());

        return article;
    }

}
