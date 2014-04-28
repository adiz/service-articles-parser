package ro.cti.ssa.fss.parser;

import org.jsoup.nodes.Document;
import ro.cti.ssa.fss.document.Book;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 4/26/2014
 */
public abstract class BookParser {

    Document document;

    public BookParser(Document document){
        this.document = document;
    }

    public abstract String getTitle();

    public abstract List<String> getAuthors();

    public abstract String getBookAbstract();

    public abstract String getBookCover();

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

    public Book createBook(){

        Book book = new Book();

        book.setTitle(getTitle());
        book.setAuthors(getAuthors());
        book.setBookAbstract(getBookAbstract());

        book.setKeywords(getKeywords());
        book.setPublication(getPublication());
        book.setPublicationDate(getPublicationDate());
        book.setPublisher(getPublisher());
        book.setEditors(getEditors());
        book.setOrganizations(getOrganizations());
        book.setEvent(getEvent());
        book.setDownloadLink(getDownloadLink());
        book.setDetails(getDetails());

        return book;
    }

}
