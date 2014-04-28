package ro.cti.ssa.fss.utils;

import org.jsoup.Jsoup;
import ro.cti.ssa.fss.parser.*;

import java.io.IOException;

/**
 * @author adrian.zamfirescu
 * @since 3/22/2014
 */
public class ArticleParserFactory {

    private static final String USER_AGENT = "Mozilla";

    public static ArticleParser getArticleParser(String url) throws IOException {

        switch (Domains.getDomainName(url)){

            case SPRINGER:
                return new SpringerParser(Jsoup.connect(url).get());

            case ACM_DL:
                return new ACMDLParser(Jsoup.connect(url).userAgent(USER_AGENT).get());

            case SCIENCE_DIRECT:
                return new ScienceDirectParser(Jsoup.connect(url).get());

            case IGI_GLOBAL:
                return new IGIGlobalParser(Jsoup.connect(url).get());

            default:
                return null;

        }
    }

}
