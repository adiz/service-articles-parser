package ro.cti.ssa.fss.document;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 4/26/2014
 */
public class Book {

    private String title;
    private List<String> authors;
    private String bookAbstract;
    private String bookCover;
    private List<String> keywords;
    private String publication;
    private String publicationDate;
    private String publisher;
    private List<String> editors;
    private List<String> organizations;
    private String event;
    private String downloadLink;
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

    public String getBookAbstract() {
        return bookAbstract;
    }

    public void setBookAbstract(String bookAbstract) {
        this.bookAbstract = bookAbstract;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<String> getEditors() {
        return editors;
    }

    public void setEditors(List<String> editors) {
        this.editors = editors;
    }

    public List<String> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<String> organizations) {
        this.organizations = organizations;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
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
          .append("Book Abstract: "+getBookAbstract()+"\n")
          .append("Book Cover: "+getBookCover()+"\n")
          .append("Keywords: "+getKeywords()+"\n")
          .append("Publication: "+getPublication()+"\n")
          .append("Publication Date: "+getPublicationDate()+"\n")
          .append("Publisher: "+getPublisher()+"\n")
          .append("Editors: "+getEditors()+"\n")
          .append("Organizations: "+getOrganizations()+"\n")
          .append("Event: "+getEvent()+"\n")
          .append("Download Link: "+getDownloadLink()+"\n")
          .append("Details: "+getDetails()+"\n")
          .append("[----------------------------------]\n");

        return sb.toString();

    }
}
