package ro.cti.ssa.fss.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 3/22/2014
 */
public class SpringerParser extends ArticleParser {

    private static final String TITLE_ID = "abstract-about-title";
    private static final String AUTHOR_CLASS = "author";
    private static final String ABSTRACT_CONTAINER_CLASS = "abstract-content formatted";
    private static final String ABSTRACT_CLASS = "a-plus-plus";

    public SpringerParser(Document document) {
        super(document);
    }

    @Override
    public String getTitle() {

        Element title = document.getElementById(TITLE_ID);
        return title.text();

    }

    @Override
    public List<String> getAuthors() {

        List<String> articleAuthors = new ArrayList<String>();

        Elements authors = document.getElementsByClass(AUTHOR_CLASS);
        for (Element author : authors)
            articleAuthors.add(commaClear(author.text()));

        return articleAuthors;

    }

    @Override
    public String getArticleAbstract() {

        Element articleAbstract = document.getElementsByClass(ABSTRACT_CONTAINER_CLASS).first();
        System.out.println("__"+document.getElementsByClass(ABSTRACT_CONTAINER_CLASS).html()+"|");
        System.out.println(articleAbstract);
        Elements element = articleAbstract.getElementsByTag(ABSTRACT_CLASS);
        return articleAbstract.getElementsByTag(ABSTRACT_CLASS).first().text();

    }

    @Override
    public List<String> getKeywords() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getPublication() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getPublicationDate() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getDetails() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private String commaClear(String text){

        if (text.endsWith(","))
            return text.substring(0,text.length()-1);
        else
            return text;

    }

}
