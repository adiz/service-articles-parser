package ro.cti.ssa.fss.utils;

/**
 * @author adrian.zamfirescu
 * @since 3/22/2014
 */
public enum Domains {

    SPRINGER,
    ACM_DL,
    SCIENCE_DIRECT,
    IGI_GLOBAL,
    SAGE_KNOWLEDGE;

    public static Domains getDomainName(String url) {

        if (url.startsWith("http://link.springer.com/article") || url.startsWith("http://link.springer.com/chapter"))
            return Domains.SPRINGER;
        else if (url.startsWith("http://dl.acm.org/citation"))
            return Domains.ACM_DL;
        else if (url.startsWith("http://www.sciencedirect.com/science/article"))
            return Domains.SCIENCE_DIRECT;
        else if (url.startsWith("http://www.igi-global.com/article") || url.startsWith("http://www.igi-global.com/chapter"))
            return Domains.IGI_GLOBAL;
        else if (url.startsWith("http://knowledge.sagepub.com/view/"))
            return Domains.SAGE_KNOWLEDGE;
        else
            return null;

    }

}
