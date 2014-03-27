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
    private static final String ITEMPROP_CLASS = "itemprop";
    private static final String ITEMPROP_VALUE = "description";
    private static final String ABSTRACT_CLASS = "a-plus-plus";
    private static final String KEYWORDS_CLASS = "abstract-keywords";
    private static final String TAG_LI = "li";
    private static final String PUBLICATION_ID = "publication-title";
    private static final String TAG_A = "a";
    private static final String COPYRIGHT_YEAR_ID = "abstract-about-book-chapter-copyright-year";

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

        Element articleAbstract = document.getElementsByAttributeValue(ITEMPROP_CLASS,ITEMPROP_VALUE).first();
        Elements elements = articleAbstract.getElementsByClass(ABSTRACT_CLASS);
        return elements.first().text();

    }

    @Override
    public List<String> getKeywords() {

        List<String> articleKeywords = new ArrayList<String>();

        Element keywordsContainer = document.getElementsByClass(KEYWORDS_CLASS).first();
        Elements keywords = keywordsContainer.getElementsByTag(TAG_LI);

        for (Element keyword : keywords)
            articleKeywords.add(keyword.text());

        return articleKeywords;
    }

    @Override
    public String getPublication() {

        Element publicationContainer = document.getElementById(PUBLICATION_ID);
        return publicationContainer.getElementsByTag(TAG_A).first().text();

    }

    @Override
    public String getPublicationDate() {

        Element year = document.getElementById(COPYRIGHT_YEAR_ID);
        return year.text();

    }

    private String commaClear(String text){

        if (text.endsWith(","))
            return text.substring(0,text.length()-1);
        else
            return text;

    }

}
