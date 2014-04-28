package ro.cti.ssa.fss.utils;

import org.jsoup.Jsoup;
import ro.cti.ssa.fss.parser.*;

import java.io.IOException;

/**
 * @author adrian.zamfirescu
 * @since 4/26/2014
 */
public class BookParserFactory {

    private static final String USER_AGENT = "Mozilla";

    public static BookParser getBookParser(String url) throws IOException {

        switch (Domains.getDomainName(url)){

            case SAGE_KNOWLEDGE:
                return new SageKnowledgeParser(Jsoup.connect(url).get());

            default:
                return null;

        }
    }

}
