package ro.cti.ssa.fss.parser;

import org.jsoup.nodes.Document;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 3/23/2014
 */
public class ACMDLParser extends ArticleParser{

    public ACMDLParser(Document document) {
        super(document);
    }

    @Override
    public String getTitle() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> getAuthors() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getArticleAbstract() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
}
