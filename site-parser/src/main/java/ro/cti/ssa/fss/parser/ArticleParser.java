package ro.cti.ssa.fss.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ro.cti.ssa.fss.article.Article;

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
        article.setDetails(getDetails());

        return article;
    }

}
