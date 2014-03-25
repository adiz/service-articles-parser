package ro.cti.ssa.fss.utils;

import org.jsoup.Jsoup;
import ro.cti.ssa.fss.parser.ACMDLParser;
import ro.cti.ssa.fss.parser.ArticleParser;
import ro.cti.ssa.fss.parser.SpringerParser;

import java.io.IOException;

/**
 * @author adrian.zamfirescu
 * @since 3/22/2014
 */
public class ArticleParserFactory {

    public static ArticleParser getArticleParser(String url) throws IOException {

        if (getDomainName(url).equals(Domains.SPRINGER))
            return new SpringerParser(Jsoup.connect(url).get());
        else if (getDomainName(url).equals(Domains.ACM_DL))
            return new ACMDLParser(Jsoup.connect(url).get());
        else
            return null;

    }

    private static String getDomainName(String url) {

        if (url.startsWith("http://link.springer.com/article") || url.startsWith("http://link.springer.com/chapter"))
            return Domains.SPRINGER;
        else if (url.startsWith("http://dl.acm.org/citation"))
            return Domains.ACM_DL;
        else
            return "null";

    }

}
