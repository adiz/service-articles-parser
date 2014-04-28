import ro.cti.ssa.fss.parser.ArticleParser;
import ro.cti.ssa.fss.parser.BookParser;
import ro.cti.ssa.fss.utils.ArticleParserFactory;
import ro.cti.ssa.fss.utils.BookParserFactory;

import java.io.IOException;

/**
 * @author adrian.zamfirescu
 * @since 3/22/2014
 */
public class Test {

    public static void main(String[] args){
        /*
        ArticleParser springer = null;
        try {
            springer = ArticleParserFactory.getArticleParser("http://link.springer.com/chapter/10.1007/978-3-642-32548-9_30");
            System.out.println(springer.createArticle());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArticleParser acmdl = null;
        try {
            acmdl = ArticleParserFactory.getArticleParser("http://dl.acm.org/citation.cfm?doid=1294928.1294930");
            System.out.println(acmdl.createArticle());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArticleParser scienceDirect = null;
        try {
            scienceDirect = ArticleParserFactory.getArticleParser("http://www.sciencedirect.com/science/article/pii/S0740624X12000160");
            System.out.println(scienceDirect.createArticle());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArticleParser igiGlobal = null;
        try {
            igiGlobal = ArticleParserFactory.getArticleParser("http://www.igi-global.com/chapter/systemic-approach-formalization-information-systems/7263");
            System.out.println(igiGlobal.createArticle());
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        BookParser sageKnowledge = null;
        try{
            sageKnowledge = BookParserFactory.getBookParser("http://knowledge.sagepub.com/view/new-service-development/n1.xml");
            System.out.println(sageKnowledge.createBook());
        } catch(IOException e){
            e.printStackTrace();
        }

    }

}
