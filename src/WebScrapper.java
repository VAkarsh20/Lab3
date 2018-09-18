import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScrapper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String word, String url) {

        int count = 0;
        int lastIndex = 0;
        String text = urlToString(url).toLowerCase();
        String newWord = word.toLowerCase();
        while(lastIndex != -1){

            lastIndex = text.indexOf(newWord,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += newWord.length();
            }
        }
        System.out.println(count);
        return count;

    }

    public static void main(String[] unused) {
        //System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount("Prince", "http://erdani.com/tdpl/hamlet.txt"));

    }
}