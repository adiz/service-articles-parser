package ro.cti.ssa.fss.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 3/29/2014
 */
public class ScienceDirectParser extends ArticleParser{

    private static final String TITLE_CLASS = "svTitle";
    private static final String AUTHOR_CLASS = "authorName";
    private static final String ABSTRACT_CONTAINER_CLASS = "svAbstract";
    private static final String KEYWORDS_CONTAINER_CLASS = "keyword";
    private static final String PUBLICATION_CONTAINER_CLASS = "title";
    private static final String PUBLICATION_DATE_CONTAINER_CLASS = "volIssue";
    private static final String TAG_P = "p";
    private static final String TAG_SPAN = "span";

    private Document articleChunk1;
    private Document articleChunk2;

    public ScienceDirectParser(Document document) throws IOException {
        super(document);
        setArticleChunks();
    }

    @Override
    public String getTitle() {

        try{
            Element title = articleChunk1.getElementsByClass(TITLE_CLASS).first();
            return title.text();
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public List<String> getAuthors() {

        List<String> articleAuthors = new ArrayList<String>();

        try{
            Elements authors = articleChunk1.getElementsByClass(AUTHOR_CLASS);
            for (Element author : authors)
                articleAuthors.add(author.text());
        } catch(Exception e){
            return null;
        }

        return articleAuthors;

    }

    @Override
    public String getArticleAbstract() {

        try{

            Element abstractDivContainer = articleChunk2.getElementsByClass(ABSTRACT_CONTAINER_CLASS).first();
            return abstractDivContainer.getElementsByTag(TAG_P).first().text();

        }
        catch(Exception e){
            return null;
        }

    }

    @Override
    public List<String> getKeywords() {

        List<String> keywords = new ArrayList<String>();

        try{

            Element keywordsUlContainer = articleChunk2.getElementsByClass(KEYWORDS_CONTAINER_CLASS).first();
            for (Element keyword : keywordsUlContainer.getElementsByTag(TAG_SPAN))
                keywords.add(keyword.text());

        }
        catch(Exception e){
            return null;
        }

        return keywords;
    }

    @Override
    public String getPublication() {

        try{

            Element publicationDivContainer = document.getElementsByClass(PUBLICATION_CONTAINER_CLASS).first();
            return publicationDivContainer.getElementsByTag(TAG_SPAN).first().text();

        }
        catch(Exception e){
            return null;
        }

    }

    @Override
    public String getPublicationDate() {

        try{

            Element publicationDateContainer = document.getElementsByClass(PUBLICATION_DATE_CONTAINER_CLASS).first();
            String publicationInfo = publicationDateContainer.text();
            String[] publicationInfoArray = publicationInfo.split(",");
            return publicationInfoArray[2].substring(1);

        }
        catch(Exception e){
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

    private void setArticleChunks() throws IOException {

        String htmlBody = document.outerHtml();

        String scriptObjectVarName = "SDM.pm.fat";
        String scriptObjectVar2Name = "SDM.pm.frag";

        int scriptObjectVarNameIndex = htmlBody.indexOf(scriptObjectVarName);
        int scriptObjectVar2NameIndex = htmlBody.indexOf(scriptObjectVar2Name);
        String sdmPmFatID = htmlBody.substring(scriptObjectVarNameIndex+scriptObjectVarName.length()+4,scriptObjectVar2NameIndex-3);

        String articleURL = document.baseUri();
        String[] domains = articleURL.split("/");
        String baseURL = domains[2];
        String articleID = domains[6];

        // get first URL for first div of information
        String articleChunk1URL = "http://"+baseURL+"/science/frag/"+articleID+"/"+sdmPmFatID+"/frag_1";
        // get second URL for second div of information
        String articleChunk2URL = "http://"+baseURL+"/science/frag/"+articleID+"/"+sdmPmFatID+"/frag_2";

        articleChunk1 = Jsoup.connect(articleChunk1URL).get();
        articleChunk2 = Jsoup.connect(articleChunk2URL).get();

    }

}
