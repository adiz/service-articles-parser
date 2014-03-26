import ro.cti.ssa.fss.parser.ArticleParser;
import ro.cti.ssa.fss.utils.ArticleParserFactory;

import java.io.IOException;

/**
 * @author adrian.zamfirescu
 * @since 3/22/2014
 */
public class Test {

    public static void main(String[] args) throws IOException {

        ArticleParser springer = ArticleParserFactory.getArticleParser("http://link.springer.com/chapter/10.1007/978-3-642-32548-9_30");
        ArticleParser acmdl = ArticleParserFactory.getArticleParser("http://dl.acm.org/citation.cfm?id=2008579.2008611&coll=DL&dl=GUIDE&CFID=308126633&CFTOKEN=28069192");

        System.out.println(springer.createArticle());
        System.out.println(acmdl.createArticle());

    }

}
