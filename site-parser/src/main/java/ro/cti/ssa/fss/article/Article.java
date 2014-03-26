package ro.cti.ssa.fss.article;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 3/23/2014
 */
public class Article {

    private String title;
    private List<String> authors;
    private String articleAbstract;
    private List<String> keywords;
    private String publication;
    private String publicationDate;
    private String details;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("[----------------------------------]\n")
          .append("Title: "+getTitle()+"\n")
          .append("Authors: "+getAuthors()+"\n")
          .append("Article Abstract: "+getArticleAbstract()+"\n")
          .append("Keywords: "+getKeywords()+"\n")
          .append("Publication: "+getPublication()+"\n")
          .append("Publication Date: "+getPublicationDate()+"\n")
          .append("Details: "+getDetails()+"\n")
          .append("[----------------------------------]\n");

        return sb.toString();

    }
}
