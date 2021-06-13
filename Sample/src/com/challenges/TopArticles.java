package com.challenges;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Article {
    String title;
    String num_comments;
    String url;
    String author;
    String story_id;
    String story_title;
    String story_url;
    String parent_id;
    String created_at;
}

class ArticleResponse {
    int page;
    int per_page;
    int total;
    int total_pages;
    List<Article> data;
}

public class TopArticles {

    /*
     * Complete the 'topArticles' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER limit as parameter.
     * base url for copy/paste:
     * https://jsonmock.hackerrank.com/api/articles?page=<pageNumber>
     */

    public static List<String> topArticles(int limit) throws IOException {
        int pageNum = 1;
        int numOfCalls = limit % 10 == 0 ? limit / 10 : (limit / 10) + 1;
        StringBuilder url = new StringBuilder("https://jsonmock.hackerrank.com/api/articles?page=");
        System.out.println("Test");
        List<Article> listOfArticles = new ArrayList();
        List<String> response = new ArrayList<>();
        while (numOfCalls-- > 0 ) {
            url.append(pageNum);
            pageNum++;
            URL jsonurl = new URL(url.toString());
            HttpURLConnection connection = (HttpURLConnection) jsonurl.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            StringBuilder result = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader(stream))) {
                int val = 0;
                while ((val = reader.read()) != -1) {
                    result.append((char) val);
                }
            }
            Reader input = new StringReader(result.toString());
            BufferedReader reader = new BufferedReader(input);
//            Gson gsonResponse = new Gson();
//            ArticleResponse currResponse = gsonResponse.fromJson(reader, ArticleResponse.class);
//            for (Article art : currResponse.data) {
//                listOfArticles.add(art);
//            }
        }

        Collections.sort(listOfArticles, new Comparator<Article>() {
            @Override
            public int compare (Article a1, Article a2) {
                int a1c = 0, a2c = 0;
                if (a1.num_comments != null) {
                    a1c = Integer.valueOf(a1.num_comments);
                }
                if (a2.num_comments != null) {
                    a2c = Integer.valueOf(a2.num_comments);
                }
                return a1c - a2c;
            }
        });
        for (int i = 0; i < limit; i++) {
            response.add(listOfArticles.get(i).title);
        }
        return response;
    }

}
