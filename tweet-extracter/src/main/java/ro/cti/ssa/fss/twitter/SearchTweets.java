package ro.cti.ssa.fss.twitter;

import twitter4j.*;

import java.util.List;

public class SearchTweets {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args
     */

    private static final String HASHTAG = "%23";

    public static void main(String[] args) {

        String twitterQuery = "https://twitter.com/search?q="+HASHTAG+"Journal";

        Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query(twitterQuery);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                System.out.println("NO TWEETS: "+tweets.size());
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
}
