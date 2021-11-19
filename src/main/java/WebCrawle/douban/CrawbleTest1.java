package WebCrawle.douban;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;


public class CrawbleTest1 {
    public static void main(String[] args) {
        String url="https://movie.douban.com/j/search_subjects?type=tv&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=0";
        //get(url);
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(url);

    }
    public static int get(String url){

        return 0;
    }

}
