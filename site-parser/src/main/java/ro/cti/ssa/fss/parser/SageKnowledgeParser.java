package ro.cti.ssa.fss.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 4/26/2014
 */
public class SageKnowledgeParser extends BookParser{

    private static final String TITLE_ID = "bookTitle";
    private static final String AUTHORS_ID = "authors";
    private static final String TAG_A = "a";
    private static final String PUBLICATION_ID = "_pubdate";
    private static final String KEYWORDS_CLASS = "keywords";

    public SageKnowledgeParser(Document document){
        super(document);
    }

    @Override
    public String getTitle() {

        try{
            Element title = document.getElementById(TITLE_ID);
            return title.text();
        } catch(Exception e){
            return null;
        }

    }

    @Override
    public List<String> getAuthors() {

        List<String> bookAuthors = new ArrayList<String>();

        try{
            Element authorsContainer = document.getElementById(AUTHORS_ID);
            Elements authors = authorsContainer.getElementsByTag(TAG_A);
            for (Element author : authors)
                bookAuthors.add(author.text());
        } catch(Exception e){
            return null;
        }

        return bookAuthors;

    }

    @Override
    public String getBookAbstract() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getBookCover() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> getKeywords() {

        List<String> bookKeywords = new ArrayList<String>();

        try{
            Element keywordsContainer = document.getElementsByClass(KEYWORDS_CLASS).first();
            Elements keywords = keywordsContainer.getElementsByTag(TAG_A);
            for (Element keyword : keywords)
                bookKeywords.add(keyword.text());
        } catch(Exception e){
            return null;
        }

        return bookKeywords;

    }

    @Override
    public String getPublication() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getPublicationDate() {

        try{

            Element publicationDateContainer = document.getElementById(PUBLICATION_ID);
            String publicationInfo = publicationDateContainer.text();
            int startYearIndex = publicationInfo.indexOf(":")+2;
            return publicationInfo.substring(startYearIndex,startYearIndex+4);

        }
        catch(Exception e){
            return null;
        }

    }

    @Override
    public String getPublisher() {

        try{

            Element publicationDateContainer = document.getElementById(PUBLICATION_ID);
            Elements spans = publicationDateContainer.getElementsByTag("span");
            return spans.get(spans.size()-1).text();

        }
        catch(Exception e){
            return null;
        }

    }

    @Override
    public List<String> getEditors() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> getOrganizations() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getEvent() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getDownloadLink() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
