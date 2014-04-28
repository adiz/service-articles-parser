package ro.cti.ssa.fss.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 4/1/2014
 */
public class IGIGlobalParser extends ArticleParser{

    private static final String META_TAG = "meta";
    private static final String NAME_ATTR = "name";
    private static final String CONTENT_ATTR = "content";

    private static final String TITLE_NAME_VALUE = "DC.title";
    private static final String AUTHORS_NAME_VALUE = "DC.creator";
    private static final String ABSTRACT_NAME_VALUE = "DC.description";

    private static final String PUBLICATION_CONTAINER_CLASS = "source";
    private static final String PUBLICATION_DATE_CONTAINER_CLASS = "bottom-space";
    private static final String TAG_A = "a";

    private Elements metadata;

    public IGIGlobalParser(Document document) {
        super(document);
        metadata = document.getElementsByTag(META_TAG);
    }

    @Override
    public String getTitle() {

        try{
            Element title = metadata.select("["+NAME_ATTR+"="+TITLE_NAME_VALUE+"]").first();
            return title.attr(CONTENT_ATTR);
        } catch(Exception e){
            return null;
        }

    }

    @Override
    public List<String> getAuthors() {

        List<String> articleAuthors = new ArrayList<String>();

        try{
            Elements authors = metadata.select("["+NAME_ATTR+"="+AUTHORS_NAME_VALUE+"]");
            for (Element author : authors)
                articleAuthors.add(nameRefactor(author.attr(CONTENT_ATTR)));
        } catch(Exception e){
            return null;
        }

        return articleAuthors;

    }

    @Override
    public String getArticleAbstract() {

        try{
            Element articleAbstract = metadata.select("["+NAME_ATTR+"="+ABSTRACT_NAME_VALUE+"]").first();
            return articleAbstract.attr(CONTENT_ATTR);
        } catch(Exception e){
            return null;
        }

    }

    @Override
    public List<String> getKeywords() {
        return null;
    }

    @Override
    public String getPublication() {

        try{
            Element publicationDivContainer = document.getElementsByClass(PUBLICATION_CONTAINER_CLASS).first();
            return publicationDivContainer.getElementsByTag(TAG_A).first().text();
        }catch(Exception e){
            return null;
        }

    }

    @Override
    public String getPublicationDate() {

        try{
            Element publicationDateContainer = document.getElementsByClass(PUBLICATION_DATE_CONTAINER_CLASS).first();
            String info = publicationDateContainer.text();
            int copyrightIndex = info.indexOf("&copy;");
            return info.substring(copyrightIndex+6,copyrightIndex+10);
        }catch(Exception e){
            return null;
        }

    }

    @Override
    public String getPublisher() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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

    private String nameRefactor(String name){

        String[] names = name.split(", ");
        return names[1]+" "+names[0];

    }

}
