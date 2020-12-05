/**
 * @Date: 12/4/2020
 * @author: Jigish, Vishwesh
 * @version: 1.2
 * @purpose: This Class converts the accesses the various URLs and converts them to corresponding text files.
 * Which are used for searching and page ranking.
 */


package accwebsearchengine;

import org.jsoup.Jsoup;
import textprocessing.In;

import java.io.PrintWriter;
import java.util.ArrayList;


public class URLtoText {

    public static void main(String[] args) {

        ArrayList<String> urlList = new ArrayList<>();

        //Use URL of own PC while running on local computer
        In in = new In("E:\\MAC\\ACC\\Web-Search-Engine\\ACC-Web-Search-Engine\\src\\accwebsearchengine\\websites.txt");

        while (!in.isEmpty()) {

            String myText = in.readLine();
            //System.out.println(myText);
            urlList.add(myText);

        }


        for (int i = 0; i < urlList.size(); i++) {

            try {

                org.jsoup.nodes.Document doc = Jsoup.connect(urlList.get(i)).get();
                String text = doc.text();
                String FilePath = "E:\\MAC\\ACC\\Web-Search-Engine\\ACC-Web-Search-Engine\\src\\accwebsearchengine\\urls\\" + (i) + ".txt";
                PrintWriter out = new PrintWriter(FilePath);
                out.println(urlList.get(i));
                out.println(text);
                System.out.println(urlList.get(i));
                out.close();


            } catch (Exception e) {

                System.out.println("Exception, Cannot be converted to text: " + urlList.get(i));
            }


        }
    }
}
